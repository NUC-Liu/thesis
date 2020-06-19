package cn.nuc.thesis.thesis;

import cn.nuc.thesis.thesis.controller.StageInfoController;
import cn.nuc.thesis.thesis.controller.ThesisInfoController;
import cn.nuc.thesis.thesis.controller.WeeklyController;
import cn.nuc.thesis.thesis.entity.StageInfoEntity;
import cn.nuc.thesis.thesis.entity.ThesisInfoEntity;
import cn.nuc.thesis.thesis.entity.WeeklyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class ThesisThesisApplicationTests {

    @Autowired
    private WeeklyController controller;

    @Test
    void contextLoads() {
        WeeklyEntity entity;
        for (int i = 1; i <= 20; i++) {
            entity = new WeeklyEntity();
            entity.setStudentNo("1614010530");
            if ((i%2)==0) {
                entity.setContent("教师测试周报内容");
                entity.setEditor("张老师");
                entity.setRole("2");
                entity.setGrade(String.valueOf(new Random().nextInt(100)));
            } else {
                entity.setContent("学生王五测试周报内容");
                entity.setEditor("王五");
                entity.setRole("1");
            }
            entity.setGmtModified(new Date());
            controller.save(entity);
        }
    }

}
