//package com.apmosys.com;
//
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.Scheduler.*;
//import org.quartz.SchedulerFactory;
//import org.quartz.Trigger;
//
//public class SchedulerTesting {
//	public static void main(String[] args) {
//		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
//
//		Scheduler sched = schedFact.getScheduler();
//

//		sched.start();
//		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("testJob").build();
//		// define the job and tie it to our HelloJob class
////		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1").build();
//		// JobDetail job = newJob
//		// Trigger the job to run now, and then every 40 seconds
//		Trigger trigger = newTrigger().withIdentity("myTrigger", "group1").startNow()
//				.withSchedule(simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();
//
//		// Tell quartz to schedule the job using our trigger
//		sched.scheduleJob(job, trigger);
//	}
//}
