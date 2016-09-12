package com.tamirm.scheduler.schedulerComponents;

/**
* @author Tamir Mayblat
* 
* The producer is used for adding new scheduled tasks to the queue    
*    
*/

import java.util.TimerTask;


public class Producer <T extends TimerTask> {

	private MyQueue<T> myQueue;

	@SuppressWarnings("unchecked")
	public Producer() {
		this.myQueue = MyQueue.getInstance();
	}
	
	public void addToQueue(T task) {
		try {
			myQueue.put(task);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
