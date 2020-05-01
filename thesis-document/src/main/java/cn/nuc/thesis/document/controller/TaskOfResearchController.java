package cn.nuc.thesis.document.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nuc.thesis.document.entity.TaskOfResearchEntity;
import cn.nuc.thesis.document.service.TaskOfResearchService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 13:02:27
 */
@RestController
@RequestMapping("document/taskofresearch")
public class TaskOfResearchController {
    @Autowired
    private TaskOfResearchService taskOfResearchService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("${moduleName}:${pathName}:list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = taskOfResearchService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("${moduleName}:${pathName}:info")
        public R info(@PathVariable("id") Long id){
		TaskOfResearchEntity taskOfResearch = taskOfResearchService.getById(id);

        return R.ok().put("taskOfResearch", taskOfResearch);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("${moduleName}:${pathName}:save")
        public R save(@RequestBody TaskOfResearchEntity taskOfResearch){
		taskOfResearchService.save(taskOfResearch);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("${moduleName}:${pathName}:update")
        public R update(@RequestBody TaskOfResearchEntity taskOfResearch){
		taskOfResearchService.updateById(taskOfResearch);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("${moduleName}:${pathName}:delete")
        public R delete(@RequestBody Long[] ids){
		taskOfResearchService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
