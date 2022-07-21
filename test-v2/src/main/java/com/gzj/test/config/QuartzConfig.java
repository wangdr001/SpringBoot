package com.gzj.test.config;

import org.quartz.*;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * Quartz配置类
 * job：任务 - 你要做什么事
 * Trigger：触发器 - 你什么时候去做
 * Scheduler：任务调度 - 你什么时候需要做什么事
 **/
@Configuration
public class QuartzConfig implements SchedulerFactoryBeanCustomizer {

    @Bean
    public Properties properties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        // 对quartz.properties文件进行读取
        //默认情况下，Quartz 会加载 classpath 下的 quartz.properties 作为配置文件。
        //如果找不到，则会使用 quartz 框架自己 jar 包下 org/quartz 底下的 quartz.properties 文件
        //propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        // 在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setQuartzProperties(properties());
        return schedulerFactoryBean;
    }

    /*
     * quartz初始化监听器
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

    @Override
    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
        // 项目启动完成后，等待2秒后开始执行调度器初始化
        schedulerFactoryBean.setStartupDelay(2);
        // 设置调度器自动运行
        schedulerFactoryBean.setAutoStartup(true);
        // 设置覆盖已存在的任务
        schedulerFactoryBean.setOverwriteExistingJobs(true);
    }
}
