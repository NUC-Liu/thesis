package cn.nuc.thesis.thesis.controller;

import java.util.Arrays;
import java.util.Map;

import cn.nuc.thesis.thesis.dto.ThesisAndStageDTO;
import cn.nuc.thesis.thesis.entity.StageInfoEntity;
import cn.nuc.thesis.thesis.service.StageInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.web.bind.annotation.*;

import cn.nuc.thesis.thesis.entity.ThesisInfoEntity;
import cn.nuc.thesis.thesis.service.ThesisInfoService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;

import javax.annotation.Resource;


/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 13:01:34
 */
@RestController
@RequestMapping("thesis/info")
public class ThesisInfoController {
    @Resource
    private ThesisInfoService thesisInfoService;

    @Resource
    private StageInfoService stageInfoService;

    /**
     * 通过用户id查询已选论文信息
     */
    @GetMapping("/selected")
    public R selected(@RequestParam(value = "studentNo") String studentNo) {
        //查询论文信息
        ThesisInfoEntity thesis = new ThesisInfoEntity();
        thesis.setStudentNo(studentNo);
        thesis = thesisInfoService.getOne(new QueryWrapper<>(thesis));
        //查询阶段信息
        StageInfoEntity stageInfoEntity = new StageInfoEntity();
        stageInfoEntity.setStudentNo(studentNo);
        stageInfoEntity = stageInfoService.getOne(new QueryWrapper<>(stageInfoEntity));
        //属性复制到DTO
        if (thesis != null && stageInfoEntity != null) {
            ThesisAndStageDTO dto = new ThesisAndStageDTO();
            BeanCopier copier = BeanCopier.create(ThesisInfoEntity.class, ThesisAndStageDTO.class, false);
            copier.copy(thesis,dto,null);
            copier = BeanCopier.create(StageInfoEntity.class,ThesisAndStageDTO.class,false);
            copier.copy(stageInfoEntity,dto,null);
            return R.ok().put("thesis", dto);
        }

        return R.error("查询论文和阶段信息异常");
    }

    /**
     * 选题
     */
    @PostMapping("/selectThesis")
    public R selectThesis(@RequestParam(value = "studentNo") String studentNo,
                          @RequestParam(value = "thesisId") Long thesisId) {
        //查看是否选过论文
        ThesisInfoEntity isSelected = thesisInfoService.getOne(new QueryWrapper<ThesisInfoEntity>().eq("student_no", studentNo));
        if (isSelected != null) return R.error("已选论文，请刷新");
        //选取论文
        boolean result1 = thesisInfoService.selectThesis(studentNo, thesisId);
        //创建阶段表表
        StageInfoEntity stageInfoEntity = new StageInfoEntity();
        stageInfoEntity.setStudentNo(studentNo);
        stageInfoEntity.setThesisId(thesisId);
        boolean result2 = stageInfoService.save(stageInfoEntity);
        return R.ok();
    }

    /**
     * 未选列表
     */
    @RequestMapping("/unSelectedList")
    @RequiresPermissions("${moduleName}:${pathName}:unSelectedList")
    public R unSelectedList(@RequestParam Map<String, Object> params){
        PageUtils page = thesisInfoService.queryUnSelectedPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("${moduleName}:${pathName}:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = thesisInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 通过教师号查列表
     */
    @RequestMapping("/listByTeacher")
    @RequiresPermissions("${moduleName}:${pathName}:list")
    public R listByTeacher(@RequestParam Map<String, Object> params){
        PageUtils page = thesisInfoService.queryPageByTeacherName(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("${moduleName}:${pathName}:info")
    public R info(@PathVariable("id") Long id){
		ThesisInfoEntity thesisInfo = thesisInfoService.getById(id);

        return R.ok().put("thesisInfo", thesisInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("${moduleName}:${pathName}:save")
    public R save(@RequestBody ThesisInfoEntity thesisInfo){
		thesisInfoService.save(thesisInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("${moduleName}:${pathName}:update")
    public R update(@RequestBody ThesisInfoEntity thesisInfo){
		thesisInfoService.updateById(thesisInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("${moduleName}:${pathName}:delete")
    public R delete(@RequestBody Long[] ids){
		thesisInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
