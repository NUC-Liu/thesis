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
 * @date 2020-05-03 02:54:41
 */
@Data
@TableName("tms_weekly")
public class WeeklyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 周报id
	 */
	@TableId
	private Long id;
	/**
	 * 周报内容
	 */
	private String content;
	/**
	 * 学生
	 */
	private String studentNo;
	/**
	 * 编辑人
	 */
	private String editor;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 分数
	 */
	private String grade;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
