package cn.nuc.thesis.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.sys.entity.SysDepartmentEntity;

import java.util.Map;

/**
 * 部门表
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 */
public interface SysDepartmentService extends IService<SysDepartmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

