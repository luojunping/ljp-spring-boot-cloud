package com.ljp.test.quartz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.TriggerBuilder;

import java.util.Map;

public abstract class TestCronTrigger {

    public static CronTrigger getCronTrigger() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.readValue("{'123':'123'}", Map.class);
        return TriggerBuilder.newTrigger().startNow().withSchedule(CronScheduleBuilder.cronSchedule("")).withIdentity("TestCronTrigger", "test").build();
    }

}
