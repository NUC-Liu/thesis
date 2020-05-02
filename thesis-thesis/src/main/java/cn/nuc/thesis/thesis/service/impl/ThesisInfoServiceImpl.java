package cn.nuc.thesis.thesis.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.thesis.dao.ThesisInfoDao;
import cn.nuc.thesis.thesis.entity.ThesisInfoEntity;
import cn.nuc.thesis.thesis.service.ThesisInfoService;


@Service("thesisInfoService")
public class ThesisInfoServiceImpl extends ServiceImpl<ThesisInfoDao, ThesisInfoEntity> implements ThesisInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ThesisInfoEntity> page = this.page(
                new Query<ThesisInfoEntity>().getPage(params),
                new QueryWrapper<ThesisInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByTeacherName(Map<String, Object> params) {
        ThesisInfoEntity entity = new ThesisInfoEntity();
        entity.setTeacherNo((String) params.get("teacherNo"));
        IPage<ThesisInfoEntity> page = this.page(
                new Query<ThesisInfoEntity>().getPage(params),
                new QueryWrapper<>(entity)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryUnSelectedPage(Map<String, Object> params) {
        IPage<ThesisInfoEntity> page = this.page(
                new Query<ThesisInfoEntity>().getPage(params),
                new QueryWrapper<ThesisInfoEntity>().isNull("student_no")
        );

        return new PageUtils(page);
    }

    @Override
    public boolean selectThesis(String studentNo, Long thesisId) {
        ThesisInfoEntity entity = new ThesisInfoEntity();
        entity.setStudentNo(studentNo);
        entity.setId(thesisId);
        return updateById(entity);
    }

}