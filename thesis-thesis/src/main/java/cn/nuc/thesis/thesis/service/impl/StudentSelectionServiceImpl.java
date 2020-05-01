package cn.nuc.thesis.thesis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.thesis.dao.StudentSelectionDao;
import cn.nuc.thesis.thesis.entity.StudentSelectionEntity;
import cn.nuc.thesis.thesis.service.StudentSelectionService;


@Service("studentSelectionService")
public class StudentSelectionServiceImpl extends ServiceImpl<StudentSelectionDao, StudentSelectionEntity> implements StudentSelectionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentSelectionEntity> page = this.page(
                new Query<StudentSelectionEntity>().getPage(params),
                new QueryWrapper<StudentSelectionEntity>()
        );

        return new PageUtils(page);
    }

}