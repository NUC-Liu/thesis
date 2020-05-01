package cn.nuc.thesis.thesis.controller;

import java.util.Arrays;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.nuc.thesis.thesis.entity.ThesisInfoEntity;
import cn.nuc.thesis.thesis.service.ThesisInfoService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



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
    @Autowired
    private ThesisInfoService thesisInfoService;

    /**
     * 查询已选论文
     */
    @GetMapping("/selected")
    public R selected(@RequestParam(value = "studentId") Long userId) {
        ThesisInfoEntity thesis = new ThesisInfoEntity();
        thesis.setStudentId(userId);
        thesis = thesisInfoService.getOne(new QueryWrapper<>(thesis));

        return R.ok().put("thesis", thesis);
    }

    /**
     * 选题 TODO
     */
    @PostMapping("/selectThesis")
    public R selectThesis(@RequestParam(value = "studentId") Long userId,
                          @RequestParam(value = "thesisId") Long thesisId) {
        //查看是否选过论文
        R isSelected = selected(userId);
        if (!"0".equals(isSelected.get("thesis.thesisId"))) return R.error("已选论文");
        //选取论文
        boolean result = thesisInfoService.selectThesis(userId,thesisId);

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
     * 信息
     */
    @RequestMapping("/info/{id}")
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
