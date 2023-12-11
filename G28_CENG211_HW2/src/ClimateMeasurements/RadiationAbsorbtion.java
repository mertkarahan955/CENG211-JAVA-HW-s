package ClimateMeasurements;
import java.util.Objects;
import java.util.Random;
public class RadiationAbsorbtion extends ClimateMeasurement{
	private double absorbtionValue;
	private static final double ABS_MIN_VALUE = 5.0;
	private static final double ABS_MAX_VALUE = 20.0;
	public enum RadiationIntensity{
		LOW, MEDIUM, HIGH
	}
	public RadiationIntensity radiationIntensity;
	// default initialize constructor
	public RadiationAbsorbtion() {
		absorbtionValue = initializeAbsorbtionValue();
		radiationIntensity = getRandomRadiationIntensity();
	}
	// copy constructor
	public RadiationAbsorbtion(RadiationAbsorbtion obj) {
		this.month = obj.month;
		this.year = obj.year;
		this.absorbtionValue = obj.absorbtionValue;
		this.radiationIntensity = obj.radiationIntensity;
	}
	private double initializeAbsorbtionValue() {
	    Random random = new Random();
	    double absorptionValue;

	    do {
	        absorptionValue = (random.nextDouble() * (ABS_MAX_VALUE - ABS_MIN_VALUE)) + ABS_MIN_VALUE;
	    } while (absorptionValue > ABS_MAX_VALUE);

	    return absorptionValue;
	}
	private RadiationIntensity getRandomRadiationIntensity() {
        RadiationIntensity[] intensities = RadiationIntensity.values();
        int random = new Random().nextInt(intensities.length);
        return intensities[random];
    }
	public double getAbsorbtionValue() {
		return absorbtionValue;
	}
	public RadiationIntensity getRadiationIntensity() {
		return radiationIntensity;
	}
	public int hashCode() {
		return Objects.hash(absorbtionValue, radiationIntensity);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RadiationAbsorbtion other = (RadiationAbsorbtion) obj;
		return Double.doubleToLongBits(absorbtionValue) == Double.doubleToLongBits(other.absorbtionValue)
				&& radiationIntensity == other.radiationIntensity;
	}
	public String toString() {
		return "RadiationAbsorbtion [absorbtionValue=" + absorbtionValue + ", radiationIntensity=" + radiationIntensity
				+ "]";
	}
}
