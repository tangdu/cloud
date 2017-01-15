package com.tdu.facade;

import com.tdu.ro.UserInfoRO;
import com.tdu.ro.UserQueryRO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("eureka.privoder")
public interface UserFacade {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name);

    @RequestMapping(value = "/queryUserInfo", method = RequestMethod.POST)
    UserInfoRO queryUserInfo(@RequestBody UserQueryRO userQueryRO);
}
