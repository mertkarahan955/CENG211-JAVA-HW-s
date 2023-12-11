package LibraryApp;

import fileIO.FileIO;
import functions.Borrower;
import functions.Searcher;
import interfaces.Borrowable;
import items.Item;

public class Query {
	
	FileIO fileIO = new FileIO();
	Searcher searcher = new Searcher();
	public void borrowedItemPrint(Borrower borrower) {
		for (Item item : fileIO.getItemList()) {
			if(item instanceof Borrowable) {
				Borrowable obj = (Borrowable) item;
				System.out.println("Item Number: " + obj.getNumber() + " "
				+ "Item Type: " + obj.chargeType()
				+ " Borrowing Days: [" + obj.borrowDateAsString() + " : " + obj.returnDateAsString() + "] "
				+ borrower.checkExceed(obj)+" Price: "+borrower.calcTotalFee(obj)+"$");
			}
		}
	}
	public void searchedItemPrint() {
		searcher.searchTitleAndType("History of Art", "book");
		searcher.searchTitle("Animal Farm");
	}

}
