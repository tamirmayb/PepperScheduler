package com.tamirm.scheduler.test;

import java.util.TimerTask;

import com.tamirm.scheduler.ScheduledEmailTask;
import com.tamirm.scheduler.schedulerComponents.Consumer;
import com.tamirm.scheduler.schedulerComponents.Producer;

import java.util.Date;

public class MyQueueImplementation {
	public static void main(String[] args) throws InterruptedException {
		
		Producer<TimerTask> producer = new Producer<TimerTask>();
		@SuppressWarnings("rawtypes")
		Consumer consumer = new Consumer();
			
		producer.addToQueue(new ScheduledEmailTask("me1@gmail.com", new Date()));
		Thread.sleep(1000);
		producer.addToQueue(new ScheduledEmailTask("me2@gmail.com", new Date()));
		Thread.sleep(1000);
		producer.addToQueue(new ScheduledEmailTask("me3@gmail.com", new Date()));
		Thread.sleep(1000);
		producer.addToQueue(new ScheduledEmailTask("me4@gmail.com", new Date()));
		Thread.sleep(1000);
		producer.addToQueue(new ScheduledEmailTask("me5@gmail.com", new Date()));

		// starting consumer to consume tasks from queue
		new Thread(consumer).start();

		System.out.println("Starting...");
	}
}
