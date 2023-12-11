package ClimateMeasurements;
import java.util.Objects;
import java.util.Random;

public class Humidity extends ClimateMeasurement{
	private double humidityPercantage;
	private static final double H_MIN_VALUE = 0.0;
    private static final double H_MAX_VALUE = 100.0;
    
    public Humidity() {
    	humidityPercantage = initializeHumidity();
    }
    // copy constructor
    public Humidity(Humidity obj) {
		this.month = obj.month;
		this.year = obj.year;
		this.humidityPercantage = obj.humidityPercantage;
	} 
    private double initializeHumidity() {
        Random random = new Random();
        double humidityPercentage;

        do {
            humidityPercentage = (random.nextDouble() * (H_MAX_VALUE - H_MIN_VALUE)) + H_MIN_VALUE;
        } while (humidityPercentage > H_MAX_VALUE);

        return humidityPercentage;
    }
    // getters
	public double getHumidityPercantage() {
		return humidityPercantage;
	}
	public int hashCode() {
		return Objects.hash(humidityPercantage);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Humidity other = (Humidity) obj;
		return Double.doubleToLongBits(humidityPercantage) == Double.doubleToLongBits(other.humidityPercantage);
	}
	public String toString() {
		return "Humidity [humidityPercantage=" + humidityPercantage + "]";
	}
}
