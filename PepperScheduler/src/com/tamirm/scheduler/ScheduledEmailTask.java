package com.tamirm.scheduler;

/**
 * @author Tamir Mayblat
 * 
 * This class creates a ScheduledEmailTask which when runs, sends an "email" (missing from this project).
 * The task is scheduled to be executed 2 days later  
 */

import java.util.Date;
import java.util.TimerTask;



//
public class ScheduledEmailTask extends TimerTask {
	
	private String recipients;
	private long sendDate;
	private long dateCreated;
	
	private static final long DELAY_IN_MILLISECONDS = 2 * 24 * 60 * 60 * 1000; // 2 DAYS
//	private static final long DELAY_IN_MILLISECONDS = 5 * 1000; // 5 sec
	
	public ScheduledEmailTask(String recipients, Date dateCreated) {
		super();
		if(recipients == null || recipients.isEmpty()) {
			throw new IllegalArgumentException("No recipients recived");
		}	
		this.recipients = recipients;
		this.sendDate = dateCreated.getTime() + DELAY_IN_MILLISECONDS;
		this.dateCreated = dateCreated.getTime(); 
	}	

	public String getRecipients() {
		return recipients;
	}

	public long getSendDate() {
		return sendDate;
	}

	public void setSendDate(long sendDate) {
		this.sendDate = sendDate;
	}

	@Override
	public String toString() {
		return "ScheduledEmailTask [recipients=" + recipients + ", sendDate=" + sendDate + "]";
	}

	@Override
	public void run(){ 
		try {
			//try to send email according to parameters and recipients list
			System.out.println("Sending email to: " + this.recipients + " from " + this.dateCreated);
		}
		catch (Exception e) {
			e.printStackTrace();
		}  
	}
}