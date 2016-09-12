package com.tamirm.scheduler.schedulerComponents;

/**
 * @author Tamir Mayblat
 * 
 * The consumer is a thread which starts after the creation of the module.
 * 
 * It checks MyQueue for tasks which their time to be executed has passed and then runs the task's run() method which performs the task's content
 *    
 */


import java.util.Date;
import java.util.TimerTask;

import com.tamirm.scheduler.ScheduledEmailTask;

public class Consumer <T extends TimerTask> implements Runnable {

	private MyQueue<T> myQueue;

	@SuppressWarnings("unchecked")
	public Consumer() {
		this.myQueue = MyQueue.getInstance();
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				TimerTask task = myQueue.peek(); // check queue for tasks
				if(task instanceof ScheduledEmailTask) {
					Date now = new Date(); 
					ScheduledEmailTask emailTask = (ScheduledEmailTask) task;
					if(now.getTime() >= emailTask.getSendDate()) {
						emailTask.run(); //execute mail send
						System.out.println("Task " + myQueue.pull() + " done!"); //remove task from queue after completion
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}