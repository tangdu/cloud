package com.tdu.config;

import com.tdu.common.interceptor.ApiInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * TODO: detail description
 *
 * @author tangdu
 * @version $: AuthWebConfig.java, v 0.1 2018年07月03日 下午5:41 tangdu Exp $
 */
@Configuration
public class AuthWebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
