package ClimateMeasurements;
import java.util.Objects;
import java.util.Random;

public class ClimateMeasurement{
	protected String year;
	protected String month;
	// initialize block statement
	{
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "Octomber",
				"November", "December"};
		Random random = new Random();
		int rInt = random.nextInt(12);
		month = months[rInt];
		String[] years = {"2020", "2021", "2022"};
		rInt = random.nextInt(3);
		year = years[rInt];
	}
	// default constructor
	public ClimateMeasurement() {}
	
	// getters
	public String getYear() {
		return year;
	}
	public String getMonth() {
		return month;
	}
	public int hashCode() {
		return Objects.hash(month, year);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClimateMeasurement other = (ClimateMeasurement) obj;
		return Objects.equals(month, other.month) &&  year == other.year;
	}
	public String toString() {
		return "ClimateMeasurement [year=" + year + ", month=" + month + ", monthToInt="  + "]";
	}	 
}
	






