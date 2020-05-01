package cn.nuc.thesis.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nuc.thesis.sys.entity.SysMajorEntity;
import cn.nuc.thesis.sys.service.SysMajorService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 专业表
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 */
@RestController
@RequestMapping("sys/sysmajor")
public class SysMajorController {
    @Autowired
    private SysMajorService sysMajorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysmajor:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMajorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysmajor:info")
    public R info(@PathVariable("id") Long id){
		SysMajorEntity sysMajor = sysMajorService.getById(id);

        return R.ok().put("sysMajor", sysMajor);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysmajor:save")
    public R save(@RequestBody SysMajorEntity sysMajor){
		sysMajorService.save(sysMajor);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysmajor:update")
    public R update(@RequestBody SysMajorEntity sysMajor){
		sysMajorService.updateById(sysMajor);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysmajor:delete")
    public R delete(@RequestBody Long[] ids){
		sysMajorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
