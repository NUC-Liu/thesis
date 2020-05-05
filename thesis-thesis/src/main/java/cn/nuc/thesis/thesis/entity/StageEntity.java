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
 * @date 2020-05-05 03:21:39
 */
@Data
@TableName("tms_stage")
public class StageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String stageName;
	/**
	 * 
	 */
	private Date startTime;
	/**
	 * 
	 */
	private Date deadline;
	/**
	 * 
	 */
	private String description;

}
