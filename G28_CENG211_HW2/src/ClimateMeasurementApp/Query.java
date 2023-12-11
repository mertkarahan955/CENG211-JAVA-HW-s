package ClimateMeasurementApp;

import java.util.ArrayList;
import java.util.Scanner;

import ClimateMeasurements.ClimateMeasurement;
import ClimateMeasurements.Humidity;
import ClimateMeasurements.RadiationAbsorbtion;
import ClimateMeasurements.Temperature;
import ClimateMeasurements.WindSpeed;
import Locations.City;
import Locations.Country;

public class Query {
	Scanner scanner = new Scanner(System.in);
	   boolean exit = false; 
	   ClimateRecord climateRecord = new ClimateRecord();
	   
	void run() {
        while (!exit) {
        	System.out.println("************************************************************************");
            System.out.println("Please select an option:");
            System.out.println("[1] Calculate average temperature for a country according to temperature unit and year.");
            System.out.println("[2] Calculate average temperature for a city according to temperature unit and year.");
            System.out.println("[3] Calculate average wind speed for a city according to speed unit and year.");
            System.out.println("[4] Calculate average humidity of a city for every year.");
            System.out.println("[5] Count how many times a year a specific radiation intensity value appears.");
            System.out.println("[6] Calculate the 'felt temperature' value for a specific month.");
            System.out.println("[7] Exit the application.");
            System.out.print("Select your option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
            // QUERY  1
                case 1:	
                	// ask country year and temperature unit
                	// avgCountryTemp();
                	System.out.print("Enter the name of the country: ");
                	Country country = climateRecord.selectedCountry(returnAndCheckCountryInput());
                	System.out.println("[1] 2020 [2] 2021 [3] 2022 :");
        			System.out.print("Please select the year: ");
        			String year = returnAndCheckYearInput(scanner);
        			ArrayList<Temperature> countryTemperatureList = climateRecord.specificTemperatureCountry(country, year);
        			System.out.print("[1] Celsius [2] Fahrenheit [3] Kelvin:");
        			int unit = scanner.nextInt();
        			switch(unit){
        			case 1:
        				System.out.println("Average temperature of " + country.getCountryName() + " in Celcius" + " in " + year + ":" + avgCountryTemp(countryTemperatureList, 1));
        				break;
        			case 2:
        				System.out.println("Average temperature of " + country.getCountryName() + " in Fahreinheit" + " in " + year + ":" + avgCountryTemp(countryTemperatureList, 2));
        				break;
        			case 3:
        				System.out.println("Average temperature of " + country.getCountryName() + " in Kelvin" + " in " + year + ":" + avgCountryTemp(countryTemperatureList, 3));
        				break;
        			}
                    break;
                // QUERY 2
                case 2:
                    // Ask  city, year, and temperature unit
                	// avgCityTemp();
                	System.out.print("Enter the name of the city: ");
                	City city = climateRecord.selectedCity(returnAndCheckCityInput());
                	System.out.println("[1] 2020 [2] 2021 [3] 2022 :");
        			System.out.print("Please select the year: ");
        			String year1 = returnAndCheckYearInput(scanner);
        			ArrayList<Temperature> cityTemperatureList = climateRecord.specificTemperatureCity(city, year1);
        			System.out.print("[1] Celsius [2] Fahrenheit [3] Kelvin:");
        			int unit1 = scanner.nextInt();
        			switch(unit1){
        			case 1:
        				System.out.println("Average temperature of " + city.getCityName() + " in Celcius" + " in " + year1 + ":" + avgCityTemp(cityTemperatureList, 1));
        				break;
        			case 2:
        				System.out.println("Average temperature of " + city.getCityName() + " in Fahreinheit" + " in " + year1 + ":" + avgCityTemp(cityTemperatureList, 2));
        				break;
        			case 3:
        				System.out.println("Average temperature of " + city.getCityName() + " in Kelvin" + " in " + year1 + ":" + avgCityTemp(cityTemperatureList, 3));
        				break;
        			}
                    break;
                // QUERY 3    
                case 3:
                    // Ask city, year, and speed unit
                    // avgCityWindSpeed();
                	System.out.print("Enter the name of the city: ");
                	City city2 = climateRecord.selectedCity(returnAndCheckCityInput());
        			ArrayList<WindSpeed> cityWindSpeedList = climateRecord.specificWindSpeedCity(city2);
        			System.out.print("[1] MetersPerSecond [2] KmPerHour : ");
        			int unitSelect = scanner.nextInt();
        			switch(unitSelect) {
        			case 1:
        				System.out.println("Average wind speed for " + city2.getCityName() + " in 3 year " + avgCityWindSpeed(cityWindSpeedList, 1) + "m/s");
        				break;
        			case 2:
        				System.out.println("Average wind speed for " + city2.getCityName() + " in 3 year " + avgCityWindSpeed(cityWindSpeedList, 2) + "km/h");
        				break;
        			}
                    break;
                    
                // QUERY 4    
                case 4:
                	// Ask city [print put the all average values for each year]
                	// avgCityHumidity();
                	System.out.print("Enter the name of the city:");
                	City city3 = climateRecord.selectedCity(returnAndCheckCityInput());
                	ArrayList<Humidity> cityHumidityList = climateRecord.specificHumidityCity(city3);
                	System.out.println("Average humidity in 3 years for " + city3.getCityName() + ": " + avgCityHumidity(cityHumidityList));
                	
                	break;
                	
                // QUERY 5
                case 5:
                	// Ask city, radiationIntensity{low, medium, high}, year
                	// amountOfRadiationIntensity();
                	System.out.print("Enter the name of the city:");
                	City city4 =  climateRecord.selectedCity(returnAndCheckCityInput());
                	System.out.println("[1] 2020 [2] 2021 [3] 2022 :");
        			System.out.print("Please select the year: ");
    				String year4 = returnAndCheckYearInput(scanner);
    				ArrayList<RadiationAbsorbtion> radiationAbsorbtionList = climateRecord.specificRadiationIntCity(city4, year4);
    				System.out.println("[1] LOW [2] MEDIUM [3] HIGH ");
    				System.out.print("Please select a radiation intensity value: ");
    				int radiationSelection = scanner.nextInt();
    				switch(radiationSelection) {
    				case 1:
    					System.out.println("Total count of low radiation intensity in " + city4.getCityName() +" in " + year4 + ": " + amountOfRadiationIntensity(radiationAbsorbtionList).get(0));
    					break;
    				case 2:
    					System.out.println("Total count of medium radiation intensity in " + city4.getCityName() +" in " + year4 + ": " + amountOfRadiationIntensity(radiationAbsorbtionList).get(1));
    					break;
    				case 3:
    					System.out.println("Total count of high radiation intensity in " + city4.getCityName() + " in " + year4 + ": " + amountOfRadiationIntensity(radiationAbsorbtionList).get(2));
    					break;
    				}
                	break;
                // QUERY 6	
                case 6:
                	// Ask city, year and month
                	// calculateCityFeltTemp();
                	System.out.print("Enter the name of the city: ");
                	City city5 = climateRecord.selectedCity(returnAndCheckCityInput());
                	System.out.println("[1] 2020 [2] 2021 [3] 2022 :");
        			System.out.print("Please select the year: ");
                	String year5 = returnAndCheckYearInput(scanner);
                	String month = returnAndCheckMonthInput(scanner);
                	ArrayList<ClimateMeasurement> climateMeasurementList = climateRecord.getMeasurementsForFeltTemperature(city5, year5, month);
                	System.out.println("Felt Temperature of " + city5.getCityName() + " in " + month + " " + year5 + ": " + calculateCityFeltTemp(climateMeasurementList, year5, month));
                	break;
                	
                // For finisinh the app.
                case 7:
                	System.out.println("==> Closing the application…");
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Closed");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option. The range is between [1-7]");
                    break;
            }
        }
        scanner.close();
    }
   // methods
   private String returnAndCheckCountryInput() {
	    String tempName = "";
	    boolean control = true;

	    while (control) {
	        String countryName = scanner.nextLine();
	        // Check country input
	        for (Country country : climateRecord.getCountryList()) {
	            if (countryName.equals(country.getCountryName())) {
	                control = false;
	                tempName = countryName;
	            }
	        }
	        if (control) {
	            System.out.print("Invalid country name. Please enter a valid country name: ");
	        }
	    }
	    return tempName;
	}
   private String returnAndCheckCityInput() {
	    String tempName = "";
	    boolean control = true;

	    while (control) {
	        String cityName = scanner.nextLine();
	        // Check city input
	        for (City city : climateRecord.getCityList()) {
	            if (cityName.equals(city.getCityName())) {
	                control = false;
	                tempName = cityName;
	            }
	        }
	        if (control) {
	            System.out.print("Invalid city name. Please enter a valid city name: ");
	        }
	    }
	    return tempName;
	}
   private String returnAndCheckYearInput(Scanner scanner) {
		String[] years = { "2020", "2021", "2022" };
		boolean numberControl = true;
		int yearChoice = 0;
		
		while (numberControl) {
			yearChoice = scanner.nextInt();
			if (yearChoice > 0 && yearChoice < 4) {
				numberControl = false;
			}
			if (numberControl) 
				System.out.print("Please enter the number correctly: ");
		}
		return years[yearChoice - 1];

	}
   private String returnAndCheckMonthInput(Scanner scanner) {
	    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
	            "November", "December"};
	    System.out.print("Please enter which month you want as a number: ");
	    int monthChoice;
	    do {
	        while (!scanner.hasNextInt()) {
	            System.out.print("Incorrect option input! Please reenter another option input: ");
	            scanner.next(); // Clear the invalid input
	        }
	        monthChoice = scanner.nextInt();
	        if (monthChoice < 1 || monthChoice > 12) {
	            System.out.print("Incorrect option input! Please reenter another option input: ");
	        }
	    } while (monthChoice < 1 || monthChoice > 12);

	    return months[monthChoice - 1];
	}

   private double avgCountryTemp(ArrayList<Temperature> temperatureList, int selection) {
	   double countryTemperature = 0;
	   for (Temperature temperature : temperatureList) {
		   
		   switch(selection) {
		   case 1:
			   countryTemperature += temperature.getCelciusMeasurement()/temperatureList.size() ;
			   break;
		   case 2:
			   countryTemperature += temperature.getFahrenheitMeasurement()/temperatureList.size();
			   break;
		   case 3:
			   countryTemperature += temperature.getKelvinMeasurement()/temperatureList.size();
			   break;
		   default:
               System.out.println("Invalid option. Please select a valid option. The range is between [1-3]");
               break;
		   }
	}
	   return countryTemperature;
   }
   private double avgCityTemp(ArrayList<Temperature> temperatureList, int selection) {
	   double cityTemperature = 0;
	   for (Temperature temperature : temperatureList) {
		   
		   switch(selection) {
		   case 1:
			   cityTemperature += temperature.getCelciusMeasurement() / temperatureList.size();
		   case 2:
			   cityTemperature += temperature.getFahrenheitMeasurement() / temperatureList.size();
			   break;
		   case 3:
			   cityTemperature += temperature.getKelvinMeasurement() / temperatureList.size();
			   break;
		   default:
               System.out.println("Invalid option. Please select a valid option. The range is between [1-3]");
               break;
		   }
	   }
	   return cityTemperature;
   }
   private double avgCityWindSpeed(ArrayList<WindSpeed> windSpeedList, int selection) {
	   double avgWindSpeed = 0;
	   for (WindSpeed windSpeed : windSpeedList) {
		   switch(selection) {
		   case 1:
			   avgWindSpeed += windSpeed.getMetersPerSecond() / windSpeedList.size();
			   break;
		   case 2:
			   avgWindSpeed += windSpeed.getKmPerHour() / windSpeedList.size();
			   break;
		   }
		
	}
	   return avgWindSpeed;
   }
   
   // average for all 3 years 
   private double avgCityHumidity(ArrayList<Humidity> humidityList) {
	   double averageHumidity = 0;
		for (Humidity humidity : humidityList) {
			averageHumidity += humidity.getHumidityPercantage() / humidityList.size();
		}
		return averageHumidity;
	}

   private ArrayList<Integer> amountOfRadiationIntensity(ArrayList<RadiationAbsorbtion> radiationAbsList) {
	    int low = 0;
	    int medium = 0;
	    int high = 0;

	    for (RadiationAbsorbtion radiation : radiationAbsList) {
	        switch (radiation.getRadiationIntensity()) {
	            case LOW:
	                low++;
	                break;
	            case MEDIUM:
	                medium++;
	                break;
	            case HIGH:
	                high++;
	                break;
	        }
	    }
	    ArrayList<Integer> intensityCounts = new ArrayList<>();
	    intensityCounts.add(low);
	    intensityCounts.add(medium);
	    intensityCounts.add(high);

	    return intensityCounts;
	}

// supporting to felt temperature calculator
   private double getCityTemperature(ArrayList<? extends ClimateMeasurement> measurementArrayList) {
	    double temp = 0;
	    for (ClimateMeasurement climateMeasurement : measurementArrayList) {
	        if (climateMeasurement instanceof Temperature) {
	            Temperature temperature = (Temperature) climateMeasurement;
	            temp += temperature.getCelciusMeasurement();
	        }
	    }
	    return temp;
	}
// supporting to felt temperature calculator
	private double getHumidityInCity(ArrayList<? extends ClimateMeasurement> measurementArrayList) {
	    double temp = 0;
	    for (ClimateMeasurement climateMeasurement : measurementArrayList) {
	        if (climateMeasurement instanceof Humidity) {
	            Humidity humidity = (Humidity) climateMeasurement;
	            temp += humidity.getHumidityPercantage() / 100;
	        }
	    }
	    return temp;
	}
	// supporting to felt temperature calculator
	private double getWindSpeedInCity(ArrayList<? extends ClimateMeasurement> measurementArrayList) {
	    double temp = 0;
	    for (ClimateMeasurement climateMeasurement : measurementArrayList) {
	        if (climateMeasurement instanceof WindSpeed) {
	            WindSpeed windSpeed = (WindSpeed) climateMeasurement;
	            temp += windSpeed.getMetersPerSecond();
	        }
	    }
	    return temp;
	}
	// supporting to felt temperature calculator
	private double getRadiationAbsorbtionInCity(ArrayList<? extends ClimateMeasurement> measurementArrayList) {
	    double temp = 0;
	    for (ClimateMeasurement climateMeasurement : measurementArrayList) {
	        if (climateMeasurement instanceof RadiationAbsorbtion) {
	            RadiationAbsorbtion radiationAbs = (RadiationAbsorbtion) climateMeasurement;
	            temp += radiationAbs.getAbsorbtionValue();
	        }
	    }
	    return temp;
	}

	private double calculateCityFeltTemp(ArrayList<? extends ClimateMeasurement> measurementList, String year, String month) {
	    double cityTemperature = getCityTemperature(measurementList);
	    double humidity = getHumidityInCity(measurementList);
	    double radiation = getRadiationAbsorbtionInCity(measurementList);
	    double windSpeed = getWindSpeedInCity(measurementList);

	    // Your calculation using the retrieved values
	    double feltTemperature = cityTemperature + 0.3 * humidity - (0.7 * (radiation / windSpeed));
	    return feltTemperature;
	}

}
