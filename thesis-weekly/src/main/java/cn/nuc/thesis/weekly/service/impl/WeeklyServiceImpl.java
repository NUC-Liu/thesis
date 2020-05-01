package cn.nuc.thesis.weekly.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.weekly.dao.WeeklyDao;
import cn.nuc.thesis.weekly.entity.WeeklyEntity;
import cn.nuc.thesis.weekly.service.WeeklyService;


@Service("weeklyService")
public class WeeklyServiceImpl extends ServiceImpl<WeeklyDao, WeeklyEntity> implements WeeklyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WeeklyEntity> page = this.page(
                new Query<WeeklyEntity>().getPage(params),
                new QueryWrapper<WeeklyEntity>()
        );

        return new PageUtils(page);
    }

}