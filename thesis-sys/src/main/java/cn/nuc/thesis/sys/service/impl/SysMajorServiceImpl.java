package cn.nuc.thesis.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.sys.dao.SysMajorDao;
import cn.nuc.thesis.sys.entity.SysMajorEntity;
import cn.nuc.thesis.sys.service.SysMajorService;

/**
 * @deprecated
 */

@Service("sysMajorService")
public class SysMajorServiceImpl extends ServiceImpl<SysMajorDao, SysMajorEntity> implements SysMajorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysMajorEntity> page = this.page(
                new Query<SysMajorEntity>().getPage(params),
                new QueryWrapper<SysMajorEntity>()
        );

        return new PageUtils(page);
    }

}