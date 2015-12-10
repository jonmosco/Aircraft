package edu.dtcc.csc214.aircraft;

import java.util.Observable;
import java.util.Observer;

public class Aircraft implements Observer {

	private static final double RadiansPerDegree = Math.PI / 180.0;
	private static final int SecondsInAnHour = 60 * 60;
	private static final double milesPerLattitudeDegree = 69.0;
	private static final double milesPerLongitudeDegree = 69.172;
	
	// current aircraft movements 
	private double currentMilesPerHour = 0.0;
	private double currentLongitude = -74.0059;
	private double currentLatitude = 40.7127;
	private double currentHeading = 0.0;
	
	// time deltas
	private long lastChange = 0;

	public void move(long numberOfMilliSeconds) {

		double milesPerSecond = currentMilesPerHour / SecondsInAnHour;
		double distance = milesPerSecond * numberOfMilliSeconds / 1000.0;
		double headingInRadian = currentHeading * RadiansPerDegree;
		
		double deltaX = (Math.cos(headingInRadian) * distance);
		double deltaY = (Math.sin(headingInRadian) * distance);
		
		currentLongitude += (deltaX / milesPerLongitudeDegree);
		currentLatitude += (deltaY / milesPerLattitudeDegree);

	}

	public double getCurrentMilesPerHour() {
		return currentMilesPerHour;
	}

	public void setCurrentMilesPerHour(double currentMilesPerHour) {
		this.currentMilesPerHour = currentMilesPerHour;
	}

	public double getCurrentLongitude() {
		return currentLongitude;
	}

	public void setCurrentLongitude(double currentLongitude) {
		this.currentLongitude = currentLongitude;
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentHeading() {
		return currentHeading;
	}

	public void setCurrentHeading(double currentHeading) {
		this.currentHeading = currentHeading;
	}

	public void update(Observable o, Object arg) {
		
		long ticks = System.currentTimeMillis();
		
		long elapsedTimeInMillSinceMovement = ticks - lastChange;
		
		lastChange = ticks;
		
		move(elapsedTimeInMillSinceMovement);
		
	}

}