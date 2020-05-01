package cn.nuc.thesis.weekly.entity;

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
 * @date 2020-04-27 12:59:05
 */
@Data
@TableName("wms_weekly")
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
	 * 学生id
	 */
	private Long studentId;
	/**
	 * 编辑人
	 */
	private String editor;
	/**
	 * 用户组
	 */
	private Integer userGroup;
	/**
	 * 评级
	 */
	private Integer grade;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
