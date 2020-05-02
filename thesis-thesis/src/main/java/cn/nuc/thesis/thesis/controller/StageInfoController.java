package cn.nuc.thesis.thesis.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.nuc.thesis.thesis.dto.StageInfoDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nuc.thesis.thesis.entity.StageInfoEntity;
import cn.nuc.thesis.thesis.service.StageInfoService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-02 17:04:00
 */
@RestController
@RequestMapping("thesis/stage")
public class StageInfoController {
    @Autowired
    private StageInfoService stageInfoService;

    /**
     * 根据教师号查询阶段
     */
    @RequestMapping("/listByTeacher")
    public R listByTeacher(@RequestParam("teacherNo") String teacherNo) {
        List<StageInfoDTO> list = stageInfoService.getByTeacherNo(teacherNo);
        return R.ok().put("stages", list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("thesis:stageinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stageInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("thesis:stageinfo:info")
    public R info(@PathVariable("id") Long id){
		StageInfoEntity stageInfo = stageInfoService.getById(id);

        return R.ok().put("stageInfo", stageInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("thesis:stageinfo:save")
    public R save(@RequestBody StageInfoEntity stageInfo){
		stageInfoService.save(stageInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("thesis:stageinfo:update")
    public R update(@RequestBody StageInfoEntity stageInfo){
		stageInfoService.updateById(stageInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("thesis:stageinfo:delete")
    public R delete(@RequestBody Long[] ids){
		stageInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
