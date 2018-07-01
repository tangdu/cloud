package com.tdu.facade;

import com.tdu.ro.UserInfoRO;
import com.tdu.ro.UserQueryRO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserFacade {

    @GetMapping(value = "/hello")
    String sayHello(@RequestParam("name") String name);

    @PostMapping(value = "/queryUserInfo")
    UserInfoRO queryUserInfo(@RequestBody UserQueryRO userQueryRO);
}
