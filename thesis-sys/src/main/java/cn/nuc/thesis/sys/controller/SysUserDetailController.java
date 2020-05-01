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

import cn.nuc.thesis.sys.entity.SysUserDetailEntity;
import cn.nuc.thesis.sys.service.SysUserDetailService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 用户补充信息
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 */
@RestController
@RequestMapping("sys/sysuserdetail")
public class SysUserDetailController {
    @Autowired
    private SysUserDetailService sysUserDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysuserdetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserDetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysuserdetail:info")
    public R info(@PathVariable("id") Long id){
		SysUserDetailEntity sysUserDetail = sysUserDetailService.getById(id);

        return R.ok().put("sysUserDetail", sysUserDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysuserdetail:save")
    public R save(@RequestBody SysUserDetailEntity sysUserDetail){
		sysUserDetailService.save(sysUserDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysuserdetail:update")
    public R update(@RequestBody SysUserDetailEntity sysUserDetail){
		sysUserDetailService.updateById(sysUserDetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysuserdetail:delete")
    public R delete(@RequestBody Long[] ids){
		sysUserDetailService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
