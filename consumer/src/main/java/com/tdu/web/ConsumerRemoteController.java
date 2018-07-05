package com.tdu.web;

import com.tdu.common.interceptor.ApiSecurity;
import com.tdu.ro.UserInfoRO;
import com.tdu.ro.UserQueryRO;
import com.tdu.servcie.UserFacadeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerRemoteController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ConsumerRemoteController.class);

    @Autowired
    private UserFacadeClient userFacadeClient;

    @RequestMapping(value = "/s_hello", method = RequestMethod.GET)
    @ResponseBody
    @ApiSecurity
    public String sayHello(@RequestParam("name") String name) {
        //String f=userFacade.moreParams(name,12);
        //LOGGER.info(f+":-------------moreParams");
        long start=System.currentTimeMillis();
        UserQueryRO userQueryRO=new UserQueryRO();
        userQueryRO.setUserName(name);
        userQueryRO.setUserId("11111");
        String sayHello = userFacadeClient.sayHello(name);
        LOGGER.info("queryUserInfo--exec:{}ms",(System.currentTimeMillis()-start));
        return sayHello;
    }

    @RequestMapping(value = "/s_user", method = RequestMethod.GET)
    @ResponseBody
    public String s_user() {
        //String f=userFacade.moreParams(name,12);
        //LOGGER.info(f+":-------------moreParams");
        long start=System.currentTimeMillis();
        UserQueryRO userQueryRO=new UserQueryRO();
        userQueryRO.setUserName("2222");
        userQueryRO.setUserId("11111");
        UserInfoRO userInfoRO = userFacadeClient.queryUserInfo(userQueryRO);
        LOGGER.info("queryUserInfo--exec:{}ms",(System.currentTimeMillis()-start));
        return "ssssssssss";
    }
}
