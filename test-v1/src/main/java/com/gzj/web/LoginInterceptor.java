package com.gzj.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor  {

    private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //获取请求参数user
        String user = request.getParameter("user") ;
        //判断验证
        if("123".equals(user)){
            LOG.info("验证通过");
            return true;
        } else {
            LOG.error("验证失败");
            return false;
        }
    }
}
