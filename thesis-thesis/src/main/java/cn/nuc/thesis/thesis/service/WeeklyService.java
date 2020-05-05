package cn.nuc.thesis.thesis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.thesis.entity.WeeklyEntity;

import java.util.Map;

/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-03 02:54:41
 */
public interface WeeklyService extends IService<WeeklyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

