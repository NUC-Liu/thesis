package cn.nuc.thesis.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.sys.entity.SysMajorEntity;

import java.util.Map;

/**
 * 专业表
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 * @deprecated
 */
public interface SysMajorService extends IService<SysMajorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

