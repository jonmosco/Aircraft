package edu.dtcc.csc214.aircraft;

public class Aircraft {
	
	private static final Double RadiansPerDegree = Math.PI / 180.0;  
	final Double milesPerLattitudeDegree = 69.0;
	final Double milesPerLongitudeDegree = 69.172;

	
	Double currentLongitude = -74.0059;
	Double currentLatitude = 40.7127;
	
	void move(Double numberOfSeconds) { 
		Double milesPerSecond = milesPerHour / SecondsInAnHour; 
		Double distance = milesPerSecond * numberOfSeconds;  
		 
		Double deltaX = (Math.cos(headingInRadian) * distance);
		Double deltaY = (Math.sin(headingInRadian) * distance); 
		 
		lastLongitude = currentLongitude;
		lastLatitude = currentLatitude;

		currentLongitude = (deltaX / milesPerLongitudeDegree) + lastLongitude;
		currentLatitude = (deltaY / milesPerLattitudeDegree) + lastLatitude; 
}


	private void convertFromUserHeadingToInternalHeadingInRadian() {
		Double internalHeading = 0.0;
		
		if (userHeading >= 0 && userHeading < 90) {
			// first quadrant
			internalHeading = 90 - userHeading;
		} else if (userHeading >= 90 && userHeading < 180) {
			// fourth quadrant
			internalHeading = -(userHeading - 90);
		} else if (userHeading < 0 && userHeading > -90) {
			// second quadrant
			internalHeading = 90 + Math.abs(userHeading);
		} else if (userHeading <= -90 && userHeading >= -180) {
			internalHeading = 90 + Math.abs(userHeading);
		}
		 
		Double userHeadingInRadian = internalHeading * RadiansPerDegree;
		// adjust the rotation by PI/2
		setHeadingInRadian(userHeadingInRadian);
		System.out.println("Setting new internal heading:" + headingInRadian);
}


}