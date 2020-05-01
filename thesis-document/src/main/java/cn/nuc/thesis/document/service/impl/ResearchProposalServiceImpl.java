package cn.nuc.thesis.document.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.document.dao.ResearchProposalDao;
import cn.nuc.thesis.document.entity.ResearchProposalEntity;
import cn.nuc.thesis.document.service.ResearchProposalService;


@Service("researchProposalService")
public class ResearchProposalServiceImpl extends ServiceImpl<ResearchProposalDao, ResearchProposalEntity> implements ResearchProposalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ResearchProposalEntity> page = this.page(
                new Query<ResearchProposalEntity>().getPage(params),
                new QueryWrapper<ResearchProposalEntity>()
        );

        return new PageUtils(page);
    }

}