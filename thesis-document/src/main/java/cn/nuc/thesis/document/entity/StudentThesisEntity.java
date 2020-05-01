package cn.nuc.thesis.document.entity;

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
 * @date 2020-04-27 13:02:28
 */
@Data
@TableName("dms_student_thesis")
public class StudentThesisEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 最终论文id
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
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
