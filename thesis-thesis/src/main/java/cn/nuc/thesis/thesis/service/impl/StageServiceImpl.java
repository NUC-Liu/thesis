package cn.nuc.thesis.thesis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.thesis.dao.StageDao;
import cn.nuc.thesis.thesis.entity.StageEntity;
import cn.nuc.thesis.thesis.service.StageService;


@Service("stageService")
public class StageServiceImpl extends ServiceImpl<StageDao, StageEntity> implements StageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StageEntity> page = this.page(
                new Query<StageEntity>().getPage(params),
                new QueryWrapper<StageEntity>()
        );

        return new PageUtils(page);
    }

}