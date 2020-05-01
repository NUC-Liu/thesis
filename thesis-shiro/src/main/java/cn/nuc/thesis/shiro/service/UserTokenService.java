package cn.nuc.thesis.shiro.service;

import cn.nuc.common.utils.R;
import cn.nuc.thesis.shiro.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserTokenService extends IService<UserEntity> {
    R createToken(long userId);
    void logout(long userId);
}
