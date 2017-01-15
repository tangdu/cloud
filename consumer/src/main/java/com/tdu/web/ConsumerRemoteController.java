package com.tdu.web;

import com.tdu.ro.UserQueryRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tdu.facade.UserFacade;

@Controller
public class ConsumerRemoteController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ConsumerRemoteController.class);

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/s_hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@RequestParam("name") String name) {
        //String f=userFacade.moreParams(name,12);
        //LOGGER.info(f+":-------------moreParams");

        UserQueryRO userQueryRO=new UserQueryRO();
        userQueryRO.setUserName(name);
        userQueryRO.setUserId("11111");

        LOGGER.info("queryUserInfo--{}",userFacade.queryUserInfo(userQueryRO));
        return userFacade.sayHello(name);
    }
}
