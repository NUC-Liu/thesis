package cn.nuc.thesis.announcement.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.nuc.common.utils.PageUtils;
import cn.nuc.common.utils.Query;

import cn.nuc.thesis.announcement.dao.AnnouncementDao;
import cn.nuc.thesis.announcement.entity.AnnouncementEntity;
import cn.nuc.thesis.announcement.service.AnnouncementService;


@Service("announcementService")
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementDao, AnnouncementEntity> implements AnnouncementService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AnnouncementEntity> page = this.page(
                new Query<AnnouncementEntity>().getPage(params),
                new QueryWrapper<AnnouncementEntity>()
        );

        return new PageUtils(page);
    }

}