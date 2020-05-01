package cn.nuc.thesis.document.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.document.dao.ReportMidTermDao;
import cn.nuc.thesis.document.entity.ReportMidTermEntity;
import cn.nuc.thesis.document.service.ReportMidTermService;


@Service("reportMidTermService")
public class ReportMidTermServiceImpl extends ServiceImpl<ReportMidTermDao, ReportMidTermEntity> implements ReportMidTermService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReportMidTermEntity> page = this.page(
                new Query<ReportMidTermEntity>().getPage(params),
                new QueryWrapper<ReportMidTermEntity>()
        );

        return new PageUtils(page);
    }

}