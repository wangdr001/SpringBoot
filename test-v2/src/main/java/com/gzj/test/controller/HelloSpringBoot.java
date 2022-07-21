package com.gzj.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringBoot {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloSpringBoot(){

        //int i = 1/0;
        return "欢迎使用SpringBoot框架";
    }
}