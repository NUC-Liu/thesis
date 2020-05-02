package cn.nuc.thesis.thesis.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ThesisAndStageDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 论文id
     */
    private Long thesisId;
    /**
     * 学号
     */
    private String studentNo;
    /**
     * 论文标题
     */
    private String title;
    /**
     * 论文号
     */
    private String thesisNo;
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 任务书路径
     */
    private String taskPath;
    /**
     * 开题报告路径
     */
    private String proposalPath;
    /**
     * 开题报告成绩
     */
    private String proposalGrade;
    /**
     * 中期报告路径
     */
    private String midPath;
    /**
     * 中期报告成绩
     */
    private String midGrade;
    /**
     * 毕设说明书路径
     */
    private String finalPath;
    /**
     * 毕设成绩
     */
    private String finalGrade;
}
