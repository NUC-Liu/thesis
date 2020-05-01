package cn.nuc.thesis.document.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.document.dao.TaskOfResearchDao;
import cn.nuc.thesis.document.entity.TaskOfResearchEntity;
import cn.nuc.thesis.document.service.TaskOfResearchService;


@Service("taskOfResearchService")
public class TaskOfResearchServiceImpl extends ServiceImpl<TaskOfResearchDao, TaskOfResearchEntity> implements TaskOfResearchService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TaskOfResearchEntity> page = this.page(
                new Query<TaskOfResearchEntity>().getPage(params),
                new QueryWrapper<TaskOfResearchEntity>()
        );

        return new PageUtils(page);
    }

}