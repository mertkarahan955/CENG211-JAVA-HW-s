package FileIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

// stringler okundu city ve country arraylistlere atildi
public class FileIO {
	private ArrayList<String> cityNames = new ArrayList<String>();
	private ArrayList<String> countryNames = new ArrayList<String>();
	
	// reader is void so we can call the method in the constructor thus we don't have to call it every time.
	public FileIO() {
		countryandCityFileIOReader();
	}

    private void countryandCityFileIOReader() {
        BufferedReader reader = null;
        String path = "src/assets/countries_and_cities.csv";
        File file = new File(path);
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            int i = 0;

            while (line != null) {
                String[] row = line.split(",");
                for (int j = 0; j < row.length; j++) {
                	if (j == 0) {
                		countryNames.add(row[0]);
					} else {
						cityNames.add(row[j].replace(" ", ""));
					}
				}
                line = reader.readLine();
                i++;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // getters 
	public ArrayList<String> getCityNames() {
		return cityNames;
	}
	public ArrayList<String> getCountryNames() {
		return countryNames;
	}
}




