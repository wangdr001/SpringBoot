package com.gzj.test.controller;

import com.gzj.test.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(path = "/quartz")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

    /**
     * 新增定时任务
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     */
    @PostMapping(path = "/addjob")
    @ResponseBody
    public String addjob(String jName, String jGroup, String tName, String tGroup, String cron) {
        try {
            quartzService.addjob(jName, jGroup, tName, tGroup, cron);
            return "添加任务成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "添加任务失败";
        }
    }

    /**
     * 暂停任务
     * @param jName 任务名称
     * @param jGroup 任务组
     */
    @PostMapping(path = "/pausejob")
    @ResponseBody
    public String pausejob(String jName, String jGroup) {
        try {
            quartzService.pausejob(jName, jGroup);
            return "暂停任务成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
            return "暂停任务失败";
        }
    }

    /**
     * 恢复任务
     * @param jName 任务名称
     * @param jGroup 任务组
     */
    @PostMapping(path = "/resumejob")
    @ResponseBody
    public String resumejob(String jName, String jGroup) {
        try {
            quartzService.resumejob(jName, jGroup);
            return "恢复任务成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
            return "恢复任务失败";
        }
    }

    /**
     * 重启任务
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param cron cron表达式
     */
    @PostMapping(path = "/reschedulejob")
    @ResponseBody
    public String rescheduleJob(String jName, String jGroup, String cron) {
        try {
            quartzService.rescheduleJob(jName, jGroup, cron);
            return "重启任务成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
            return "重启任务失败";
        }
    }

    /**
     * 删除任务
     * @param jName 任务名称
     * @param jGroup 任务组
     */
    @PostMapping(path = "/deletejob")
    @ResponseBody
    public String deletejob(String jName, String jGroup) {
        try {
            quartzService.deletejob(jName, jGroup);
            return "删除任务成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
            return "删除任务失败";
        }
    }

}
