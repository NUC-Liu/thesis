package cn.nuc.thesis.thesis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.thesis.entity.StageEntity;

import java.util.Map;

/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-05 03:21:39
 */
public interface StageService extends IService<StageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

