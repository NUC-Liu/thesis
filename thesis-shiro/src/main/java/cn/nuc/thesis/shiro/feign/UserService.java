package cn.nuc.thesis.shiro.feign;

import cn.nuc.common.utils.R;
import cn.nuc.thesis.shiro.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "thesis-user")
public interface UserService {

    @RequestMapping("/queryByUserName")
    UserEntity queryByUserName(String username);

    @RequestMapping("/login")
    R login(@RequestBody UserEntity userEntity);
}
