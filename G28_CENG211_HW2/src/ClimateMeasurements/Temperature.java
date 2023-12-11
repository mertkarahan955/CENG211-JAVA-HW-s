package ClimateMeasurements;
import java.util.Objects;
import java.util.Random;

public class Temperature extends ClimateMeasurement{
	private double celciusMeasurement;
	private double fahrenheitMeasurement;
	private double kelvinMeasurement;
	private static final double C_MIN_VALUE = -40.0;
	private static final double C_MAX_VALUE = 50.0;

	public Temperature() {
			celciusMeasurement = initializeTemperature();
			fahrenheitMeasurement = 9*(celciusMeasurement) + 32;
			kelvinMeasurement = celciusMeasurement + 273;
	}	
	// copy constructor from base temperature object
	public Temperature(Temperature obj) {
		this.month = obj.month;
		this.year = obj.year;
		this.celciusMeasurement = obj.celciusMeasurement;
		this.fahrenheitMeasurement = obj.fahrenheitMeasurement;
		this.kelvinMeasurement = obj.kelvinMeasurement;
	}
	private double initializeTemperature() {
	    Random random = new Random();
	    double celciusMeasurement;

	    do {
	        celciusMeasurement = C_MIN_VALUE + (random.nextDouble() * (C_MAX_VALUE - C_MIN_VALUE));
	    } while (celciusMeasurement > C_MAX_VALUE);

	    return celciusMeasurement;
	}
	// getters
	public double getCelciusMeasurement() {
		return celciusMeasurement;
	}
	public double getFahrenheitMeasurement() {
		return fahrenheitMeasurement;
	}
	public double getKelvinMeasurement() {
		return kelvinMeasurement;
	}
	public int hashCode() {
		return Objects.hash(celciusMeasurement, fahrenheitMeasurement, kelvinMeasurement);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temperature other = (Temperature) obj;
		return Double.doubleToLongBits(celciusMeasurement) == Double.doubleToLongBits(other.celciusMeasurement)
				&& Double.doubleToLongBits(fahrenheitMeasurement) == Double
						.doubleToLongBits(other.fahrenheitMeasurement)
				&& Double.doubleToLongBits(kelvinMeasurement) == Double.doubleToLongBits(other.kelvinMeasurement);
	}
	public String toString() {
		return "Temperature [celciusMeasurement=" + celciusMeasurement + ", fahrenheitMeasurement="
				+ fahrenheitMeasurement + ", kelvinMeasurement=" + kelvinMeasurement + "]";
	}
}
