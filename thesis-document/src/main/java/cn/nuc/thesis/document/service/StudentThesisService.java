package cn.nuc.thesis.document.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.document.entity.StudentThesisEntity;

import java.util.Map;

/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 13:02:28
 */
public interface StudentThesisService extends IService<StudentThesisEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

