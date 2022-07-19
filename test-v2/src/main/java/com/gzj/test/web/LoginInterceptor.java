package com.gzj.test.web;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  每次发送请求时需要在请求头中放入`user`，值不限，在访问controller前需要输出`user`请求头对应的值
 */

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor  {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //获取请求参数user
        String user = request.getParameter("user") ;
        //判断验证
        if("123".equals(user)){
            log.info("验证通过");
            return true;
        } else {
            log.error("验证失败");
            return false;
        }
    }
}
