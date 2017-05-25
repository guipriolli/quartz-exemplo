package com.guilherme.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

/**
 *
 * @author Guibl
 */
public class Job implements org.quartz.Job {

//    public static final String MSG = "";
//    
    public Job() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String msg = dataMap.getString("msg");

        System.out.println(msg);
    }
}
