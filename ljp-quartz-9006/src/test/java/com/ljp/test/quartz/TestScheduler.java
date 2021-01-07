package com.ljp.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestScheduler {

    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity("testJob", "test").build();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().startNow().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

}
