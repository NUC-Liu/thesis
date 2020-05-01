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
 * @date 2020-04-27 13:01:34
 */
public interface StageService extends IService<StageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
