package cn.nuc.thesis.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户补充信息
 * 
 * @author Liu
 * @email 568419374@qq.com
 * @date 2020-04-30 11:55:55
 */
@Data
@TableName("sys_user_detail")
public class SysUserDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户编号
	 */
	private String userNo;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户身份
	 */
	private String role;
	/**
	 * 部门id
	 */
	private Long departmentId;
	/**
	 * 专业id
	 */
	private Long majorId;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
