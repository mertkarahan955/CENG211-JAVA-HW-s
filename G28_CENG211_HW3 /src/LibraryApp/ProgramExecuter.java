package LibraryApp;
import functions.Borrower;

public class ProgramExecuter {

	public void run() {
		Query query = new Query();
		Borrower borrower = new Borrower();
			
		query.borrowedItemPrint(borrower);
		System.out.println("************************************");
		query.searchedItemPrint();
		
		
		}
	}

