package ClimateMeasurementApp;
import java.util.ArrayList;

import ClimateMeasurements.ClimateMeasurement;
import ClimateMeasurements.Humidity;
import ClimateMeasurements.RadiationAbsorbtion;
import ClimateMeasurements.Temperature;
import ClimateMeasurements.WindSpeed;
import FileIO.FileIO;
import Locations.City;
import Locations.Country;

public class ClimateRecord{
	
	private ArrayList<Country> countryList = new ArrayList<Country>();
	// we need to merge country and city objects with respect to their names
	private ArrayList<String> countryNamesList;
	private ArrayList<City> cityList = new ArrayList<City>();
	private ArrayList<String> cityNamesList;
	
	// use initialize block for setting country and city names from fileIO
	{
		FileIO fileIO = new FileIO();
		countryNamesList = fileIO.getCountryNames();
		cityNamesList = fileIO.getCityNames();
	}
	public ClimateRecord() {
		setCountries();
		setCities();
	}
	private void setCountries(){
		for (String countryName : countryNamesList) {
			countryList.add(new Country(countryName));
		}
	}
	private void  setCities(){
		for (String cityName : cityNamesList) {
			cityList.add(new City(cityName));
		}
	}
	public Country selectedCountry(String selectedCountryName) {
		Country temp = null;
		for (Country country : countryList) {
			if(country.getCountryName().equals(selectedCountryName)) {
				temp = country;
			}
		}
		return temp;	
	}
	public City selectedCity(String selectedCityName) {
		City temp = null;
		for (City city : cityList) {
			if(city.getCityName().equals(selectedCityName)) {
				 temp = city;
			}
		}
		return temp;
	}
	// helper to query 1.
	public ArrayList<Temperature> specificTemperatureCountry(Country country, String year){
		// we need temporary array list for return.
		ArrayList<Temperature> tempTemperature = new ArrayList<Temperature>();
		for (Temperature temperature : country.getCountryTemperatureList()) {
			if(temperature.getYear().equals(year)) {
				tempTemperature.add(temperature);
			}
		}
		return tempTemperature;
	}
	// helper to query 2.
	public ArrayList<Temperature> specificTemperatureCity(City city, String year){
		// we need temporary array list for return.
		ArrayList<Temperature> tempTemperature = new ArrayList<Temperature>();
		for (Temperature temperature : city.getCityTemperatureList()) {
			if(temperature.getYear().equals(year)) {
				tempTemperature.add(temperature);
			}
		}
		return tempTemperature;
	}
	// helper to query 3.
	public ArrayList<WindSpeed> specificWindSpeedCity(City city){
		// we need temporary array list for return.
		ArrayList<WindSpeed> tempWindSpeed = new ArrayList<WindSpeed>();
		for (WindSpeed windSpeed : city.getCityWindSpeedList()) {
			
				tempWindSpeed.add(windSpeed);
		}
		return tempWindSpeed;
	}
	// helper to query 4.
	public ArrayList<Humidity> specificHumidityCity(City city){
		
		return city.getCityHumidityList();
		// nothing to change instruction just needs the list of 3 year humidity data.
	}
	// helper to query 5.
	public ArrayList<RadiationAbsorbtion> specificRadiationIntCity(City city, String year){
		ArrayList<RadiationAbsorbtion> tempRadiationAbsorbtion = new ArrayList<RadiationAbsorbtion>();
		for (RadiationAbsorbtion radiationAbsorbtion : city.getCityRadiationAbsList()) {
			if(radiationAbsorbtion.getYear().equals(year)) {
				tempRadiationAbsorbtion.add(radiationAbsorbtion);
			}
		}
		return tempRadiationAbsorbtion;
	}
	// helper to query 6.
	public ArrayList<ClimateMeasurement> getMeasurementsForFeltTemperature(City city, String year, String month) {
	    ArrayList<ClimateMeasurement> climateMeasurementList = new ArrayList<>();

	    filterMeasurementsByDate(city.getCityTemperatureList(), year, month, climateMeasurementList);
	    filterMeasurementsByDate(city.getCityHumidityList(), year, month, climateMeasurementList);
	    filterMeasurementsByDate(city.getCityRadiationAbsList(), year, month, climateMeasurementList);
	    filterMeasurementsByDate(city.getCityWindSpeedList(), year, month, climateMeasurementList);

	    return climateMeasurementList;
	}

	private void filterMeasurementsByDate(ArrayList<? extends ClimateMeasurement> measurements, String year, String month, ArrayList<ClimateMeasurement> result) {
	    for (ClimateMeasurement climateMeasurement : measurements) {
	        if (climateMeasurement.getYear().equals(year) && climateMeasurement.getMonth().equals(month)) {
	            result.add(climateMeasurement);
	        }
	    }
	}

	public ArrayList<Country> getCountryList() {
		return countryList;
	}
	public ArrayList<City> getCityList() {
		return cityList;
	}
}
