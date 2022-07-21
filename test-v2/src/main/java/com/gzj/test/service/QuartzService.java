package com.gzj.test.service;

import org.quartz.SchedulerException;

public interface QuartzService {

    /**
     * 添加   暂停   恢复   重启   删除
     */
    void addjob(String jName, String jGroup, String tName, String tGroup, String cron);

    void pausejob(String jName, String jGroupe) throws SchedulerException;

    void resumejob(String jName, String jGroup) throws SchedulerException;

    void rescheduleJob(String jName, String jGroup, String cron) throws SchedulerException;

    void deletejob(String jName, String jGroup) throws SchedulerException;
}
