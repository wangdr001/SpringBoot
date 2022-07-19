package com.gzj.config;

import com.gzj.web.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyAppConfig implements WebMvcConfigurer {

    //添加拦截器对象， 注入到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //创建拦截器对象
        HandlerInterceptor loginInterceptor = new LoginInterceptor();

        //指定拦截的请求uri地址
        String path []= {"/**"};
        //指定不拦截的地址
        String excludePath  [] = {"/hello"};
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(path)
                .excludePathPatterns(excludePath);

    }
}
