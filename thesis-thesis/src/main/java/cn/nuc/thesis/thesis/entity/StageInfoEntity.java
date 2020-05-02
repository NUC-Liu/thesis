package cn.nuc.thesis.thesis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-05-02 17:35:08
 */
@Data
@TableName("tms_stage_info")
public class StageInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 学号
	 */
	private String studentNo;
	/**
	 * 论文id
	 */
	private Long thesisId;
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
