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

import cn.nuc.thesis.sys.entity.SysDepartmentEntity;
import cn.nuc.thesis.sys.service.SysDepartmentService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 部门表
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 * @deprecated
 */
@RestController
@RequestMapping("sys/sysdepartment")
public class SysDepartmentController {
    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysdepartment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDepartmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:sysdepartment:info")
    public R info(@PathVariable("id") Long id){
		SysDepartmentEntity sysDepartment = sysDepartmentService.getById(id);

        return R.ok().put("sysDepartment", sysDepartment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysdepartment:save")
    public R save(@RequestBody SysDepartmentEntity sysDepartment){
		sysDepartmentService.save(sysDepartment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysdepartment:update")
    public R update(@RequestBody SysDepartmentEntity sysDepartment){
		sysDepartmentService.updateById(sysDepartment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysdepartment:delete")
    public R delete(@RequestBody Long[] ids){
		sysDepartmentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
