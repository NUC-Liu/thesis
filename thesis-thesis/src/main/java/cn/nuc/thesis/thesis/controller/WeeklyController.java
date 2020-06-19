package cn.nuc.thesis.thesis.controller;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.nuc.thesis.thesis.entity.WeeklyEntity;
import cn.nuc.thesis.thesis.service.WeeklyService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.R;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-03 02:54:41
 */
@RestController
@RequestMapping("thesis/weekly")
public class WeeklyController {
    @Autowired
    private WeeklyService weeklyService;

    /**
     * 接受前台传过来的图片
     */
    @RequestMapping("/uploadImg")
    public R uploadImg(@RequestParam("file") MultipartFile file) {
        String basePath = "E:\\thesis repository";
        String filePath = basePath + "\\" + file.getOriginalFilename();
        File desFile = new File(filePath);
        if(!desFile.getParentFile().exists()){
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return R.error().put("errno", 404);
        }
        return R.ok().put("fullUrl", filePath);
    }

    /**
     * 根据学号查周报
     */
    @RequestMapping("/listByStudent")
    public R listByStudent(@RequestParam("studentNo") String studentNo) {
        WeeklyEntity weeklyEntity = new WeeklyEntity();
        weeklyEntity.setStudentNo(studentNo);
        List<WeeklyEntity> list = weeklyService.list(new QueryWrapper<>(weeklyEntity));
        return R.ok().put("weekly", list);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("thesis:weekly:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = weeklyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("thesis:weekly:info")
    public R info(@PathVariable("id") Long id){
		WeeklyEntity weekly = weeklyService.getById(id);

        return R.ok().put("weekly", weekly);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("thesis:weekly:save")
    public R save(@RequestBody WeeklyEntity weekly){
        if (weekly.getContent().length() > 1000) return R.error("内容太长");
		weeklyService.save(weekly);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("thesis:weekly:update")
    public R update(@RequestBody WeeklyEntity weekly){
		weeklyService.updateById(weekly);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("thesis:weekly:delete")
    public R delete(@RequestBody Long[] ids){
		weeklyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
