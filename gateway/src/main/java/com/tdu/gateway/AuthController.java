package com.tdu.gateway;

import com.tdu.common.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: detail description
 *
 * @author tangdu
 * @version $: AuthController.java, v 0.1 2018年07月05日 上午9:26 tangdu Exp $
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        String jwt = JwtUtil.buildJWT("233232322232232323232");
//        response.addHeader("Authorization", "Bearer "+jwt);
        return ResponseEntity.ok(jwt);
    }
}
