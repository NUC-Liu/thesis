package cn.nuc.thesis.thesis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.thesis.dao.StudentPunishDao;
import cn.nuc.thesis.thesis.entity.StudentPunishEntity;
import cn.nuc.thesis.thesis.service.StudentPunishService;


@Service("studentPunishService")
public class StudentPunishServiceImpl extends ServiceImpl<StudentPunishDao, StudentPunishEntity> implements StudentPunishService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentPunishEntity> page = this.page(
                new Query<StudentPunishEntity>().getPage(params),
                new QueryWrapper<StudentPunishEntity>()
        );

        return new PageUtils(page);
    }

}