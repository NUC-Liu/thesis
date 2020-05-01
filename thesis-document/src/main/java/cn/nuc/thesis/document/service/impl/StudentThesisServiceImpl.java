package cn.nuc.thesis.document.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.document.dao.StudentThesisDao;
import cn.nuc.thesis.document.entity.StudentThesisEntity;
import cn.nuc.thesis.document.service.StudentThesisService;


@Service("studentThesisService")
public class StudentThesisServiceImpl extends ServiceImpl<StudentThesisDao, StudentThesisEntity> implements StudentThesisService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentThesisEntity> page = this.page(
                new Query<StudentThesisEntity>().getPage(params),
                new QueryWrapper<StudentThesisEntity>()
        );

        return new PageUtils(page);
    }

}