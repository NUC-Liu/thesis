package cn.nuc.thesis.announcement.entity;

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
 * @date 2020-04-27 13:00:11
 */
@Data
@TableName("ams_announcement")
public class AnnouncementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 公告id
	 */
	@TableId
	private Long id;
	/**
	 * 公告内容
	 */
	private String content;
	/**
	 * 发布人
	 */
	private String editor;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;

}
