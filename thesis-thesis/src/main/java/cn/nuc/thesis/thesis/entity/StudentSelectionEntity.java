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
 * @date 2020-04-27 13:01:34
 */
@Data
@TableName("tms_student_selection")
public class StudentSelectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 选题id
	 */
	@TableId
	private Long id;
	/**
	 * 论文id
	 */
	private Long thesisId;
	/**
	 * 学生id
	 */
	private Long studentId;
	/**
	 * 阶段id
	 */
	private Long stageId;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
