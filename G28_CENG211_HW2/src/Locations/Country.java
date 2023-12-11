package Locations;
import java.util.ArrayList;
import java.util.Objects;

import ClimateMeasurements.ClimateMeasurement;
import ClimateMeasurements.Temperature;

public class Country {
	private String countryName;
	private ArrayList<Temperature> countryTemperatureList = new ArrayList<Temperature>();
	
	public Country(String countryName) {
		this.countryName = countryName;
		addAllTemperaturesToTempArray();
	}
	
	private void addAllTemperaturesToTempArray() {
		while(countryTemperatureList.size() != 36) {
			// it will add 36 temperature objects with respect to 36 months of total 3 years
			Temperature temperature = new Temperature();
			// avoiding for add duplicate 
			if(!checkDate(temperature, countryTemperatureList)) {
				countryTemperatureList.add(temperature);
			}
		}
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
	public String toString() {
		return "Country [name=" + countryName + ", countryTempList=" + countryTemperatureList + "]";
	}
	public int hashCode() {
		return Objects.hash(countryName, countryTemperatureList);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(countryName, other.countryName) && Objects.equals(countryTemperatureList, other.countryTemperatureList);
	}
	public String getCountryName() {
		return countryName;
	}
	public ArrayList<Temperature> getCountryTemperatureList() {
		return countryTemperatureList;
	}
}
