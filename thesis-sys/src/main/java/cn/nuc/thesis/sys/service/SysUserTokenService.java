package cn.nuc.thesis.sys.service;

import cn.nuc.common.utils.R;
import cn.nuc.thesis.sys.entity.SysUserTokenEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户Token
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
