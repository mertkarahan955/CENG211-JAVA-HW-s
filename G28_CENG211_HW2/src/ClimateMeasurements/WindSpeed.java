package ClimateMeasurements;

import java.util.Objects;
import java.util.Random;

public class WindSpeed extends ClimateMeasurement{
	private double metersPerSecond;
	private double kmPerHour;
	private static final double SPEED_MIN_VALUE = 0.0;
	private static final double SPEED_MAX_VALUE = 113.2;
	
	// default init constructor
	public WindSpeed() {
		metersPerSecond = initializeWindSpeed();
		kmPerHour = metersPerSecond * 3.6;
	}
	
	// copy constructor
	public WindSpeed(WindSpeed obj) {
		this.month = obj.month;
		this.year = obj.year;
		this.metersPerSecond = obj.metersPerSecond;
		this.kmPerHour = obj.kmPerHour;
	}
	
	private double initializeWindSpeed() {
	    Random random = new Random();
	    double metersPerSecond;

	    do {
	        metersPerSecond = (random.nextDouble() * (SPEED_MAX_VALUE - SPEED_MIN_VALUE)) + SPEED_MIN_VALUE;
	    } while (metersPerSecond > SPEED_MAX_VALUE);

	    return metersPerSecond;
	}
	
	public double getMetersPerSecond() {
		return metersPerSecond;
	}
	public double getKmPerHour() {
		return kmPerHour;
	}
	public int hashCode() {
		return Objects.hash(kmPerHour, metersPerSecond);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WindSpeed other = (WindSpeed) obj;
		return Double.doubleToLongBits(kmPerHour) == Double.doubleToLongBits(other.kmPerHour)
				&& Double.doubleToLongBits(metersPerSecond) == Double.doubleToLongBits(other.metersPerSecond);
	}
	public String toString() {
		return "WindSpeed [metersPerSecond=" + metersPerSecond + ", kmPerHour=" + kmPerHour + "]";
	}
}
