package com.apmosys.com;

import java.io.File;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		 File dir = new File("/Mont_SBI_WebFramework/target/");
//		    File max = null;
//		    for (File file : dir.listFiles()) {
//		        if (file.isDirectory() && (max == null || max.lastModified() < file.lastModified())) {
//		            max = file;
//		        }
//		    }
//		    System.out.println(max.getName());
		System.out.println("hello");
	}

}
