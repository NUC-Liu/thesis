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
 * @date 2020-04-27 13:02:27
 */
@Data
@TableName("dms_task_of_research")
public class TaskOfResearchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 任务表id
	 */
	@TableId
	private Long id;
	/**
	 * 论文id
	 */
	private Long thesisId;
	/**
	 * 教师id
	 */
	private Long teacherId;
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
