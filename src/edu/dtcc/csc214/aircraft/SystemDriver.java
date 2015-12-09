package edu.dtcc.csc214.aircraft;

import java.util.Observable;

public class SystemDriver extends Observable implements Runnable {
	
	public static void main(String[] args) {
	
        ScheduledTask ourTask = new ScheduledTask();

        // create our thread
        Thread myThread = new Thread(ourTask);

        // Create a Scheduled Task instance
        ScheduledTask newTask = new ScheduledTask();

        ourTask.addObserver(newTask);

        myThread.start();
        
	}

	public static void setHeading(Double newHeading) {
		// TODO Auto-generated method stub
		
	}

	public static void setSpeed(Double newSpeed) {
		// TODO Auto-generated method stub
		
	}

	public static void resetAirplane() {
		// TODO Auto-generated method stub
		
	}

	public static Object getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
