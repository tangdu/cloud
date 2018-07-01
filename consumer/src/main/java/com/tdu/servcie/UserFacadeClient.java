package com.tdu.servcie;

import com.tdu.facade.UserFacade;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * TODO: detail description
 *
 * @author tangdu
 * @version $: UserFacadeClient.java, v 0.1 2017年12月2017/12/24日 下午5:58 tangdu Exp $
 * @name TODO: UserFacadeClient
 */
@FeignClient(name="provider",path = "/user")
public interface UserFacadeClient extends UserFacade {
}
