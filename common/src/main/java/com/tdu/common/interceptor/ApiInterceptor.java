package com.tdu.common.interceptor;

import com.tdu.common.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO: detail description
 *
 * @author tangdu
 * @version $: WebInterceptor.java, v 0.1 2018年07月03日 下午5:13 tangdu Exp $
 */
public class ApiInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod    = (HandlerMethod) handler;
        ApiSecurity   methodAnnotation = handlerMethod.getBeanType().getAnnotation(ApiSecurity.class);
        if (methodAnnotation == null) {
            methodAnnotation = handlerMethod.getMethodAnnotation(ApiSecurity.class);
        }
        String token = request.getHeader("Authorization");
        if (methodAnnotation != null) {
            boolean flag = StringUtils.isNotBlank(token) ? JwtUtil.checkJWT(token) : false;
            if (!flag) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        return super.preHandle(request, response, handler);
    }
}
