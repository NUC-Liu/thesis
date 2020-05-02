package cn.nuc.thesis.thesis.service;

import cn.nuc.thesis.thesis.dto.StageInfoDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.thesis.entity.StageInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-02 17:04:00
 */
public interface StageInfoService extends IService<StageInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);


    List<StageInfoDTO> getByTeacherNo(String teacherNo);
}

