package cn.nuc.thesis.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.sys.dao.SysDepartmentDao;
import cn.nuc.thesis.sys.entity.SysDepartmentEntity;
import cn.nuc.thesis.sys.service.SysDepartmentService;


@Service("sysDepartmentService")
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentDao, SysDepartmentEntity> implements SysDepartmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysDepartmentEntity> page = this.page(
                new Query<SysDepartmentEntity>().getPage(params),
                new QueryWrapper<SysDepartmentEntity>()
        );

        return new PageUtils(page);
    }

}