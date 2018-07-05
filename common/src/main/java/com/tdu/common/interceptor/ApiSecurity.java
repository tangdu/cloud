package com.tdu.common.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO: detail description
 *
 * @author tangdu
 * @version $: ApiSecurity.java, v 0.1 2018年07月03日 下午5:35 tangdu Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD,ElementType.TYPE})
public @interface ApiSecurity {
}
