package com.gzj.test.web;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        // jobExecutionContext.getTrigger().getJobDataMap(); 可以获取传入的参数
        // 实现业务逻辑

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        log.info("Hello Job执行时间: " + dateFormat.format(date));
    }
}
