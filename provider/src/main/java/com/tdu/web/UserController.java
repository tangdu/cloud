package com.tdu.web;

import com.tdu.facade.UserFacade;
import com.tdu.ro.UserInfoRO;
import com.tdu.ro.UserQueryRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements UserFacade {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    public String sayHello(String name) {
        return String.format("%s 你好。世界。", name);
    }

    public UserInfoRO queryUserInfo( UserQueryRO userQueryRO){
        LOGGER.info("queryUserInfo {} ",userQueryRO);
        UserInfoRO userInfoRO=new UserInfoRO();
        BeanUtils.copyProperties(userQueryRO,UserInfoRO.class);
        userInfoRO.setAge(Integer.MAX_VALUE);
        return userInfoRO;
    }
}
