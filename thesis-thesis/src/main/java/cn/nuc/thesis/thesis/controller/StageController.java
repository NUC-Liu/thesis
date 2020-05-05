package cn.nuc.thesis.thesis.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nuc.thesis.thesis.entity.StageEntity;
import cn.nuc.thesis.thesis.service.StageService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-05 03:21:39
 */
@RestController
@RequestMapping("thesis/stageTable")
public class StageController {
    @Autowired
    private StageService stageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("thesis:stage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("thesis:stage:info")
    public R info(@PathVariable("id") Long id){
		StageEntity stage = stageService.getById(id);

        return R.ok().put("stage", stage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("thesis:stage:save")
    public R save(@RequestBody StageEntity stage){
		stageService.save(stage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("thesis:stage:update")
    public R update(@RequestBody StageEntity stage){
		stageService.updateById(stage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("thesis:stage:delete")
    public R delete(@RequestBody Long[] ids){
		stageService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
