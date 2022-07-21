package com.gzj.test.service.impl;

import com.gzj.test.service.QuartzService;
import com.gzj.test.web.HelloJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    private Scheduler scheduler;

    /**
     * 新增定时任务
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     */
    @Override
    public void addjob(String jName, String jGroup, String tName, String tGroup, String cron) {
        log.info("定时任务开始创建 名称：{} cron表达式：{}",jName,cron);
        try {
            // 构建JobDetail
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity(jName, jGroup)
                    .build();
            // 按新的cronExpression表达式构建一个新的trigger
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(tName, tGroup)
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();//执行
            // 启动调度器
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
            log.info("定时任务创建成功 名称：{} cron表达式：{}",jName,cron);
        } catch (Exception e) {
            log.error("定时任务错误 名称：{} cron表达式：{}",jName,cron);
        }
    }

    @Override
    public void pausejob(String jName, String jGroup) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jName, jGroup));
    }

    @Override
    public void resumejob(String jName, String jGroup) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(jName, jGroup));
    }

    @Override
    public void rescheduleJob(String jName, String jGroup, String cron) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jName, jGroup);
        // 表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // 按新的cronExpression表达式重新构建trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        // 按新的trigger重新设置job执行，重启触发器
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    @Override
    public void deletejob(String jName, String jGroup) throws SchedulerException {
        scheduler.pauseTrigger(TriggerKey.triggerKey(jName, jGroup));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jName, jGroup));
        scheduler.deleteJob(JobKey.jobKey(jName, jGroup));
    }
}
