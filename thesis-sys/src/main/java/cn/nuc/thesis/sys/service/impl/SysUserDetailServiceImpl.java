package cn.nuc.thesis.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.sys.dao.SysUserDetailDao;
import cn.nuc.thesis.sys.entity.SysUserDetailEntity;
import cn.nuc.thesis.sys.service.SysUserDetailService;


@Service("sysUserDetailService")
public class SysUserDetailServiceImpl extends ServiceImpl<SysUserDetailDao, SysUserDetailEntity> implements SysUserDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserDetailEntity> page = this.page(
                new Query<SysUserDetailEntity>().getPage(params),
                new QueryWrapper<SysUserDetailEntity>()
        );

        return new PageUtils(page);
    }

}