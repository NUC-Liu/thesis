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
@TableName("tms_thesis_info")
public class ThesisInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 论文id
	 */
	@TableId
	private Long id;
	/**
	 * 论文号
	 */
	private String thesisNo;
	/**
	 * 论文标题
	 */
	private String title;
	/**
	 * 教师编号
	 */
	private String teacherNo;
	/**
	 * 教师姓名
	 */
	private String teacherName;
	/**
	 * 摘要
	 */
	private String description;
	/**
	 * 备选状态
	 */
	private String studentNo;
	/**
	 * 任务书路径
	 */
	private String taskPath;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
