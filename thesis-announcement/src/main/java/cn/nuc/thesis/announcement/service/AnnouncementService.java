package cn.nuc.thesis.announcement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.thesis.announcement.entity.AnnouncementEntity;

import java.util.Map;

/**
 * 
 *
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-27 13:00:11
 */
public interface AnnouncementService extends IService<AnnouncementEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

