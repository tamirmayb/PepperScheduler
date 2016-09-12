package com.tamirm.scheduler.schedulerComponents;

/**
 * @author Tamir Mayblat
 * 
 * The class MyQueue is a thread safe ArrayBlockingQueue singleton ordered by first in first out (FIFO)  
 * 
 * The queue is a container for scheduled tasks scheduled to be executed
 *    
 */

import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

public class MyQueue<T extends TimerTask> {
	@SuppressWarnings("rawtypes")
	private static MyQueue instance;
	private ArrayBlockingQueue<T> myQueue = new ArrayBlockingQueue<T>(9999);
	
	private MyQueue() {
		
	}

	public static MyQueue getInstance() {
		if(instance == null) {
			instance = new MyQueue<>();
		}
		return instance;
	}
	
	public synchronized void put(T t) throws InterruptedException {
		myQueue.add(t);
		notify();
	}

	// Return the first object out of the queue. Wait if the queue is empty.
	public synchronized T pull() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		return get();
	}

	// Get the first object out of the queue. Return null if the queue is empty.
	public synchronized T get() {
		T object = peek();
		if (object != null)
			myQueue.remove(object);
		return object;
	}

	// Peek to see if queue has any elements available.
	public T peek() {
		if (isEmpty())
			return null;
		return myQueue.peek();
	}

	public boolean isEmpty() {
		return myQueue.isEmpty();
	}

	public int size() {
		return myQueue.size();
	}

}
