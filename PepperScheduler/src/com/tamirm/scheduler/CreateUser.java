package com.tamirm.scheduler;

/**
 * @author Tamir Mayblat
 * 
 * During the user creation phase (will not be developed for this project) a confirmation email needs to be delivered to the user.
 * This class creates a Producer for the scheduler queue and a ScheduledEmailTask to be sent to the queue and scheduled  
 */


import java.util.Date;
import java.util.TimerTask;

import com.tamirm.scheduler.schedulerComponents.Producer;

public class CreateUser {
	public static void createUserFromParams(String userName, String emailAddress) {
		//TODO add missing user creation logic
		
		//Send email after registering
		Producer<TimerTask> producer = new Producer<>();
		producer.addToQueue(new ScheduledEmailTask(emailAddress, new Date()));
	}
}
