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

import cn.nuc.thesis.document.entity.StudentThesisEntity;
import cn.nuc.thesis.document.service.StudentThesisService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 13:02:28
 */
@RestController
@RequestMapping("document/studentthesis")
public class StudentThesisController {
    @Autowired
    private StudentThesisService studentThesisService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("${moduleName}:${pathName}:list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentThesisService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("${moduleName}:${pathName}:info")
        public R info(@PathVariable("id") Long id){
		StudentThesisEntity studentThesis = studentThesisService.getById(id);

        return R.ok().put("studentThesis", studentThesis);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("${moduleName}:${pathName}:save")
        public R save(@RequestBody StudentThesisEntity studentThesis){
		studentThesisService.save(studentThesis);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("${moduleName}:${pathName}:update")
        public R update(@RequestBody StudentThesisEntity studentThesis){
		studentThesisService.updateById(studentThesis);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("${moduleName}:${pathName}:delete")
        public R delete(@RequestBody Long[] ids){
		studentThesisService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
