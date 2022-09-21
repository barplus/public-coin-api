package com.coin.web.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CommonSecure {

    boolean needLogin() default true;
    boolean isLogin() default false;
    boolean fastQuery() default false;

}
