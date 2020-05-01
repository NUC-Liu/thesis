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
@TableName("tms_stage")
public class StageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 阶段id
	 */
	@TableId
	private Long id;
	/**
	 * 阶段名
	 */
	private String stageName;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 截至日期
	 */
	private Date deadline;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
