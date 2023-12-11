package fileIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import enums.Priority;
import items.Book;
import items.Item;
import items.Magazin;
import members.GeneralMember;
import members.Member;
import members.NormalStudent;
import members.ScholarShipStudent;

public class FileIO {
	
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public FileIO() {
		fileIOReader();
	}
	private void fileIOReader() {
		BufferedReader reader = null;
		String path = "src/assets/items.csv";
		File file = new File(path);
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(file));
			line = reader.readLine();
			Item currentItem;
			
			while(line != null){
				
				String[] row = line.split(";");
				
				if(row[3].equalsIgnoreCase("book")) {
					
					 currentItem = new Book(
						    row[0], 
						    row[4].replace(" ", "_"), 
						    fromStringToPriorityEnum(row[2]),
						    row[1].replace(" ", "_"), 
						    row[3].replace(" ", "_"), 
						    row[5].replace(" ", "_"), 
						    fromStringToMember(row[6]),
						    stringToDate(row[7]),
						    stringToDate(row[8]));
					 
					
					itemList.add(currentItem);
					
				}
				else if (row[3].equalsIgnoreCase("magazine")) {
					currentItem = new Magazin(
						    row[0], 
						    row[1].replace(" ", "_"), 
						    fromStringToPriorityEnum(row[2]), 
						    row[3].replace(" ", "_"),
						    row[4].replace(" ", "_"), 
						    row[5].replace(" ", "_"), 
						    fromStringToMember(row[6]),
						    stringToDate(row[7]),
						    stringToDate(row[8])
						    
						);
					
					itemList.add(currentItem);
					
				}
				line = reader.readLine();
			}
			} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	public static Priority fromStringToPriorityEnum(String representation) {
	    try {
	        // Replace spaces with underscores and convert to uppercase
	        String enumName = representation.replace(" ", "_").toUpperCase();
	        return Priority.valueOf(enumName);
	    } catch (IllegalArgumentException | NullPointerException e) {
	        // Handle the case where the input string is not a valid enum constant
	        throw new IllegalArgumentException("Invalid Priority: " + representation);
	    }
	}


	public static Date stringToDate(String dateString) {
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        return dateFormat.parse(dateString);
	    } catch (ParseException e) {
	        // Handle the case where the input string is not a valid date
	        throw new IllegalArgumentException("Invalid date: " + dateString, e);
	    }
	}

	public static Member fromStringToMember(String memberName) {
	    if (memberName.equalsIgnoreCase("studentWScholar")) {
	        return new ScholarShipStudent(memberName);
	    } else if (memberName.equalsIgnoreCase("studentWOScholar")) {
	        return new NormalStudent(memberName);
	    } else {
	        return new GeneralMember(memberName);
	    }
	}


	public ArrayList<Item> getItemList() {
		return itemList;
	}


}


