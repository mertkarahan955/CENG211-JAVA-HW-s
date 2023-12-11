package functions;
import java.util.ArrayList;
import fileIO.FileIO;
import interfaces.Borrowable;
import interfaces.Searchable;
import items.Item;

public class Searcher {
	
	ArrayList<Searchable> searchableList = new ArrayList<Searchable>();
	Borrower borrower = new Borrower();
	private void fillSearchableList() {
		FileIO fileIO = new FileIO();
		for (Item item : fileIO.getItemList()) {
			if(item instanceof Searchable) {
				searchableList.add(item);
			}
		}
	}
	public Searcher() {
	fillSearchableList();
	}
	
	public void searchTitle(String title) {
	    title = title.replace(" ", "_");
	    boolean found = false;

	    for (Searchable searchable : searchableList) {
	        if (searchable.getTitle().equalsIgnoreCase(title)) {
	            if (searchable instanceof Borrowable) {
	                Borrowable obj = (Borrowable) searchable;
	                found = true;
	                System.out.println("Exist " + "Item Number: " + obj.getNumber()
	                        + " Title: " + searchable.getTitle() + " Borrowing Days: " + obj.borrowDate() + "-" + obj.returnDate()
	                        + " " + borrower.checkExceed(obj) + " Price: " + borrower.calcTotalFee(obj) + "$");
	                break;
	            }
	        }
	    }
	    if (!found) {
	        System.out.println("Does not exist");
	    }
	}
	
	public void searchTitleAndType(String title, String itemType) {
	    title = title.replace(" ", "_");
	    boolean found = false;

	    for (Searchable searchable : searchableList) {
	    	
	        if (searchable.getTitle().equalsIgnoreCase(title) && searchable.getItemType().equalsIgnoreCase(itemType)) {
	        	if(searchable instanceof Borrowable) {
	        		Borrowable obj = (Borrowable) searchable;
	        	System.out.println("Exist " + "Item Number: " + obj.getNumber() 
	            +" Title: " + searchable.getTitle() + " Borrowing Days: [" +obj.borrowDateAsString() + " : " + obj.returnDateAsString()
	            + "] "+  borrower.checkExceed(obj) + " Price: " + borrower.calcTotalFee(obj)+ "$");
	            found = true;
	   
	            break;
	        } 	
	        }
	    }
	    if (!found) {
	        System.out.println("Does not exist");
	    }
	}
	public ArrayList<Searchable> getSearchableList() {
		return searchableList;
	}
}


