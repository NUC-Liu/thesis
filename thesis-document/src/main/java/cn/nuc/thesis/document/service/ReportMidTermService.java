package cn.nuc.thesis.document.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.document.entity.ReportMidTermEntity;

import java.util.Map;

/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 13:02:28
 */
public interface ReportMidTermService extends IService<ReportMidTermEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

