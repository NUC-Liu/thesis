package cn.nuc.thesis.thesis.service.impl;

import cn.nuc.thesis.thesis.dto.StageInfoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.thesis.dao.StageInfoDao;
import cn.nuc.thesis.thesis.entity.StageInfoEntity;
import cn.nuc.thesis.thesis.service.StageInfoService;


@Service("stageInfoService")
public class StageInfoServiceImpl extends ServiceImpl<StageInfoDao, StageInfoEntity> implements StageInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StageInfoEntity> page = this.page(
                new Query<StageInfoEntity>().getPage(params),
                new QueryWrapper<StageInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<StageInfoDTO> getByTeacherNo(String teacherNo) {
        return baseMapper.selectBatchByTeacherNo(teacherNo);
    }


}