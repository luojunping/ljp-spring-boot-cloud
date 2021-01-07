package com.ljp.test.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        String group = jobDetail.getKey().getGroup();
        String name = jobDetail.getKey().getName();
        System.out.println("group = " + group + ", name = " + name);
        System.out.println(LocalDateTime.now(ZoneId.of("Asia/Chongqing")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.now(ZoneId.of("America/Chicago")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
