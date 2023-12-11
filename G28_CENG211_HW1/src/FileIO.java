//getProductArray
//getShopAssistantArray


// BufferReader

// Read line method

// String Split

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	private Product[] productArray = new Product[90];
	private ShopAssistant[] assistantArray = new ShopAssistant[100];
	
	public Product[] ProductFileIOReader() {
		BufferedReader reader = null;
		String path= "assets/products.csv";
		File file = new File(path);
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();
			int i = 0 ;
			while (line != null) {
	        	String [] row = line.split(";");
	            Product product = new Product(row[0], row[1], Double.parseDouble(row[2].replace(",", "."))); 
	            productArray[i] = product;
				i++;	
				line = reader.readLine();
			}
			reader.close();
			return productArray;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		}
	
	public ShopAssistant[] AssistantFileIOReader() {
		BufferedReader reader = null;
		String path = "assets/shopAssistants.csv";
		File file = new File(path);
		String line = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();
			int i = 0 ;
			while (line != null) {
	        	String [] row = line.split(";");
	            ShopAssistant shopAssistant = new ShopAssistant(row[0], row[1], row[2],row[3]);
	            assistantArray[i] = shopAssistant;
				i++;	
				line = reader.readLine();
			}
			reader.close();
			return assistantArray;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		}
			

}
