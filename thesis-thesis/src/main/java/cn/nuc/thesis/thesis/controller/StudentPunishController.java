package cn.nuc.thesis.thesis.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.nuc.thesis.thesis.entity.WeeklyEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nuc.thesis.thesis.entity.StudentPunishEntity;
import cn.nuc.thesis.thesis.service.StudentPunishService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;



/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-02 16:43:52
 */
@RestController
@RequestMapping("thesis/punish")
public class StudentPunishController {
    @Autowired
    private StudentPunishService studentPunishService;

    /**
     * 通过学号查惩戒
     */
    @RequestMapping("listByStudent")
    public R listByStudent(@RequestParam("studentNo") String studentNo) {
        StudentPunishEntity entity = new StudentPunishEntity();
        entity.setStudentNo(studentNo);
        List<StudentPunishEntity> list = studentPunishService.list(new QueryWrapper<>(entity));
        return R.ok().put("punish", list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("thesis:studentpunish:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentPunishService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("thesis:studentpunish:info")
    public R info(@PathVariable("id") Long id){
		StudentPunishEntity studentPunish = studentPunishService.getById(id);

        return R.ok().put("studentPunish", studentPunish);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("thesis:studentpunish:save")
    public R save(@RequestBody StudentPunishEntity studentPunish){
		studentPunishService.save(studentPunish);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("thesis:studentpunish:update")
    public R update(@RequestBody StudentPunishEntity studentPunish){
		studentPunishService.updateById(studentPunish);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("thesis:studentpunish:delete")
    public R delete(@RequestBody Long[] ids){
		studentPunishService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
