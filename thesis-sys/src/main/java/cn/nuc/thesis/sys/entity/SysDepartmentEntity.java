package cn.nuc.thesis.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门表
 * 
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 */
@Data
@TableName("sys_department")
public class SysDepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 院系id
	 */
	@TableId
	private Long id;
	/**
	 * 学院名
	 */
	private String departmentName;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
