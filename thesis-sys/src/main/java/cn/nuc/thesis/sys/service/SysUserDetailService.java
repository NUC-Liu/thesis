package cn.nuc.thesis.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.sys.entity.SysUserDetailEntity;

import java.util.Map;

/**
 * 用户补充信息
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 * @deprecated
 */
public interface SysUserDetailService extends IService<SysUserDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

