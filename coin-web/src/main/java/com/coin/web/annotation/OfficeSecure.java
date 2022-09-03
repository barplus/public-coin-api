package com.coin.web.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OfficeSecure {

    boolean needAuth() default true;
    boolean needLogin() default true;
    boolean doDownLoad() default false;
    boolean fastQuery() default false;
    
}
