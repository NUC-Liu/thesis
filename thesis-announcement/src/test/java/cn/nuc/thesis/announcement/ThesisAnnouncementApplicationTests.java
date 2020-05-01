package cn.nuc.thesis.announcement;

import cn.nuc.thesis.announcement.entity.AnnouncementEntity;
import cn.nuc.thesis.announcement.service.AnnouncementService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@SpringBootTest
class ThesisAnnouncementApplicationTests {

    @Resource
    AnnouncementService announcementService;

    @Test
    void contextLoads() {
        AnnouncementEntity announcementEntity = new AnnouncementEntity();
        announcementEntity.setContent("test renren");
        announcementEntity.setEditor("liu");
        Date date = new Date(System.currentTimeMillis());
        announcementEntity.setGmtCreate(date);
        announcementEntity.setGmtModified(announcementEntity.getGmtCreate());
        List<AnnouncementEntity> list = announcementService.list(new QueryWrapper<AnnouncementEntity>().eq("editor", "liu"));
        list.forEach(System.out::println);
    }

}
