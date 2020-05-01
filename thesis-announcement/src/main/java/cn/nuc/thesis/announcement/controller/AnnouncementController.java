package cn.nuc.thesis.announcement.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nuc.thesis.announcement.entity.AnnouncementEntity;
import cn.nuc.thesis.announcement.service.AnnouncementService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 13:00:11
 */
@RestController
@RequestMapping("announcement")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    /**
     * 列表
     */
    @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = announcementService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Long id){
		AnnouncementEntity announcement = announcementService.getById(id);

        return R.ok().put("announcement", announcement);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("${moduleName}:${pathName}:save")
        public R save(@RequestBody AnnouncementEntity announcement){
		announcementService.save(announcement);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("${moduleName}:${pathName}:update")
        public R update(@RequestBody AnnouncementEntity announcement){
		announcementService.updateById(announcement);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("${moduleName}:${pathName}:delete")
        public R delete(@RequestBody Long[] ids){
		announcementService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
