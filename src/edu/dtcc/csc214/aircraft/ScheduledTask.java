package edu.dtcc.csc214.aircraft;

import java.sql.Timestamp;
import java.util.Observable;

public class ScheduledTask extends Observable implements Runnable {

	public ScheduledTask() {
	}

	public void run() {
		notifyObservers();
		try {
			while (true) {
				// notify the object that we woke up
				super.notifyObservers(new Object());

				// sleep for a second
				// 1000 Milliseconds == one second
				Thread.sleep(1000);
				setChanged();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	// get current time stamp
	public Timestamp tick() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

}
