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
@TableName("tms_student_punish")
public class StudentPunishEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 记过表id
	 */
	@TableId
	private Long id;
	/**
	 * 惩罚
	 */
	private String punishment;
	/**
	 * 描述
	 */
	private String descirption;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
