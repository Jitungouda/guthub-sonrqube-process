package com.apmosys.com;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Scheduling {

	public static void main(String[] args) {

		try {

			// specify the job' s details..
			JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity("testJob").build();
			JobDetail job1 = JobBuilder.newJob(TestJob.class).withIdentity("testJob1").build();
			// specify the running period of the job
			Trigger trigger = TriggerBuilder.newTrigger()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatSecondlyForTotalCount(5, 3))
					.build();
			Trigger trigger1 = TriggerBuilder.newTrigger()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
					.build();
			CronTrigger trigger10 = TriggerBuilder.newTrigger().withIdentity("trigger10")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 29 12 * * ? 2022")).forJob("testJob1")
					.build();
			CronTrigger trigger11 = TriggerBuilder.newTrigger().withIdentity("trigger11")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 33 12 1/1 * ? *")).forJob("testJob")
					.build();

			// schedule the job
			SchedulerFactory schFactory = new StdSchedulerFactory();
			Scheduler sch = schFactory.getScheduler();
			SchedulerFactory schFactory1 = new StdSchedulerFactory();
			Scheduler sch1 = schFactory1.getScheduler();
			sch.start();
			sch1.start();
//			sch.scheduleJob(job, trigger);
			sch1.scheduleJob(job, trigger11);
			sch1.scheduleJob(job1, trigger10);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}