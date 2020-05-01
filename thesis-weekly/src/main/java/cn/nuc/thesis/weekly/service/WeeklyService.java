package cn.nuc.thesis.weekly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.weekly.entity.WeeklyEntity;

import java.util.Map;

/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 12:59:05
 */
public interface WeeklyService extends IService<WeeklyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

