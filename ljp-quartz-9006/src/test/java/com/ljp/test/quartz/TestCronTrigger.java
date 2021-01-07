package com.ljp.test.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.TriggerBuilder;

public abstract class TestCronTrigger {

    public static CronTrigger getCronTrigger() {
        return TriggerBuilder.newTrigger().startNow().withSchedule(CronScheduleBuilder.cronSchedule("")).withIdentity("TestCronTrigger", "test").build();
    }

}
