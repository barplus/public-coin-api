package com.coin.web.config;

import com.coin.web.interceptor.RequestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebResourceConfigure extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

//    /**
//     * 跨域
//     * @param registry
//     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry){
//        registry.addMapping("/**")
//                .allowedOriginPatterns("*")
//                .allowedMethods("POST", "GET")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }

    @Bean
    public FilterRegistrationBean corsFilter(){
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        List<String> methods = new ArrayList<>();
        methods.add("OPTIONS");
        methods.add("HEAD");
        methods.add("GET");
        methods.add("POST");
        config.setAllowedMethods(methods);
        config.setMaxAge(3600L);
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(configSource));
        bean.setOrder(0);
        return bean;
    }

    @Bean
    public RequestInterceptor getRequestInterceptor(){
        return new RequestInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getRequestInterceptor())
                .addPathPatterns("/**") //拦截所有再添加例外
                .excludePathPatterns(
                        "/error"
                );
    }

}
