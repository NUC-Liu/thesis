package cn.nuc.thesis.thesis.dao;

import cn.nuc.thesis.thesis.dto.StageInfoDTO;
import cn.nuc.thesis.thesis.entity.StageInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-02 17:04:00
 */
@Mapper
public interface StageInfoDao extends BaseMapper<StageInfoEntity> {

    List<StageInfoDTO> selectBatchByTeacherNo(String teacherNo);
}
