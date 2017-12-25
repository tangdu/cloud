package com.tdu.facade;

import com.tdu.ro.UserInfoRO;
import com.tdu.ro.UserQueryRO;
import org.springframework.web.bind.annotation.*;

public interface UserFacade {

    @GetMapping(value = "/hello")
    String sayHello(@RequestParam("name") String name);

    @PostMapping(value = "/queryUserInfo")
    UserInfoRO queryUserInfo(@RequestBody UserQueryRO userQueryRO);
}
