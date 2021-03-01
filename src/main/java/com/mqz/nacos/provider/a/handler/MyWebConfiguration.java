package com.mqz.nacos.provider.a.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mqz
 * @description
 * @since 2020/4/20
 */
@Configuration
public class MyWebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> ex = new ArrayList<>();
        ex.add("/doc.html");
        ex.add("/swagger-ui.html/**");
        ex.add("/swagger-resources/**");
        ex.add("v2/**");
        ex.add("/api-docs");
        registry.addInterceptor(new AccessInterceptor()).addPathPatterns("/**").excludePathPatterns(ex);
    }

}
