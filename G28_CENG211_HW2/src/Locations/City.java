package Locations;
import java.util.ArrayList;
import java.util.Objects;
import ClimateMeasurements.ClimateMeasurement;
import ClimateMeasurements.Humidity;
import ClimateMeasurements.RadiationAbsorbtion;
import ClimateMeasurements.Temperature;
import ClimateMeasurements.WindSpeed;

public class City {
	private String cityName;
	private double feltTemperature;
	private ArrayList<Temperature> cityTemperatureList = new ArrayList<Temperature>();
	private ArrayList<Humidity> cityHumidityList = new ArrayList<Humidity>();
	private ArrayList<RadiationAbsorbtion> cityRadiationAbsList = new ArrayList<RadiationAbsorbtion>();
	private ArrayList<WindSpeed> cityWindSpeedList = new ArrayList<WindSpeed>();
	
	public City(String cityName) {
		this.cityName = cityName;
		addAllHumidityToArray();
		addAllRadiationAbsToArray();
		addAllTemperaturesToTempArray();
		addAllWindSpeedToArray();
	}
	
	private  boolean checkDate(ClimateMeasurement obj, ArrayList<? extends ClimateMeasurement> measurementArrayList) {
	    boolean temp = false;
	    for (ClimateMeasurement object : measurementArrayList) {
	        if (obj.getMonth().equals(object.getMonth()) && obj.getYear().equals(object.getYear())) {
	            temp = true;          
	        }
	    }
	    return temp;
	}
	
	private void addAllTemperaturesToTempArray() {
		while(cityTemperatureList.size() != 36) {
			// it will add 36 temperature objects with respect to 36 months of total 3 years
			Temperature temperature = new Temperature();
			// avoiding for add duplicate 
			if(!checkDate(temperature, cityTemperatureList)) {
				cityTemperatureList.add(temperature);
			}
		}
	}
	private void addAllHumidityToArray() {
		// it will add 36 temperature objects with respect to 36 months of total 3 years
		while(cityHumidityList.size() != 36) {
			Humidity humidity = new Humidity();
			// avoiding for add duplicate 
			if(!checkDate(humidity,cityHumidityList )) {
				cityHumidityList.add(humidity);
			}
		}
	}
	private void addAllRadiationAbsToArray() {
		while(cityRadiationAbsList.size() != 36) {
			// it will add 36 temperature objects with respect to 36 months of total 3 years
			RadiationAbsorbtion radiationAbs = new RadiationAbsorbtion();
			// avoiding for add duplicate 
			if(!checkDate(radiationAbs,cityRadiationAbsList )) {
				cityRadiationAbsList.add(radiationAbs);
			}
		}
	}
	private void addAllWindSpeedToArray() {
		// it will add 36 temperature objects with respect to 36 months of total 3 years
		while(cityWindSpeedList.size() != 36) {
			WindSpeed windSpeed = new WindSpeed();
			// avoiding for add duplicate 
			if(!checkDate(windSpeed,cityWindSpeedList )) {
				cityWindSpeedList.add(windSpeed);
			}
		}
	}
	public String getCityName() {
		return cityName;
	}
	public double getFeltTemperature() {
		return feltTemperature;
	}
	public ArrayList<Temperature> getCityTemperatureList() {
		return cityTemperatureList;
	}
	public ArrayList<Humidity> getCityHumidityList() {
		return cityHumidityList;
	}
	public ArrayList<RadiationAbsorbtion> getCityRadiationAbsList() {
		return cityRadiationAbsList;
	}
	public ArrayList<WindSpeed> getCityWindSpeedList() {
		return cityWindSpeedList;
	}
	public int hashCode() {
		return Objects.hash(cityHumidityList, cityName, cityRadiationAbsList, cityTemperatureList, cityWindSpeedList,
				feltTemperature);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(cityHumidityList, other.cityHumidityList) && Objects.equals(cityName, other.cityName)
				&& Objects.equals(cityRadiationAbsList, other.cityRadiationAbsList)
				&& Objects.equals(cityTemperatureList, other.cityTemperatureList)
				&& Objects.equals(cityWindSpeedList, other.cityWindSpeedList)
				&& Double.doubleToLongBits(feltTemperature) == Double.doubleToLongBits(other.feltTemperature);
	}
	public String toString() {
		return "City [cityName=" + cityName + ", feltTemperature=" + feltTemperature + ", cityTemperatureList="
				+ cityTemperatureList + ", cityHumidityList=" + cityHumidityList + ", cityRadiationAbsList="
				+ cityRadiationAbsList + ", cityWindSpeedList=" + cityWindSpeedList + "]";
	}	
}
