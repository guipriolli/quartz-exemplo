/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.quartz;

import java.util.LinkedList;
import java.util.List;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Guibl
 */
public class main {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        
        try {
            
            String name = "job1";
            String msg = "Hello World!";
            String cron = "0/5 * * * * ?";
            
            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            
            JobDetail job1 = JobBuilder.newJob(Job.class)
                    .withIdentity(name, "group1")
                    .usingJobData("msg", msg)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .build();
            
            scheduler.start();
            scheduler.scheduleJob(job1, trigger);
            
        
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    
}
