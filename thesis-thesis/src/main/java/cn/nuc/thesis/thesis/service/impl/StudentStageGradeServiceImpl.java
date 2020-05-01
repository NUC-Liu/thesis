package cn.nuc.thesis.thesis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.thesis.dao.StudentStageGradeDao;
import cn.nuc.thesis.thesis.entity.StudentStageGradeEntity;
import cn.nuc.thesis.thesis.service.StudentStageGradeService;


@Service("studentStageGradeService")
public class StudentStageGradeServiceImpl extends ServiceImpl<StudentStageGradeDao, StudentStageGradeEntity> implements StudentStageGradeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentStageGradeEntity> page = this.page(
                new Query<StudentStageGradeEntity>().getPage(params),
                new QueryWrapper<StudentStageGradeEntity>()
        );

        return new PageUtils(page);
    }

}