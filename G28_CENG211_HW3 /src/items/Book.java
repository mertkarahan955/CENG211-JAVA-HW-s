package items;
import java.util.Date;
import enums.Priority;
import functions.Borrower;
import members.Member;

public class Book extends Item {
	Borrower borrower = new Borrower();
	
	public Book(String number, String title, Priority priority,String itemType, String author, String publisher, Member member,
			Date borrowDate, Date returnDate) {
		super(number, itemType, priority, author, publisher, publisher, member, borrowDate, returnDate);
		
	}

	@Override
	public String toString() {
		return "Book [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	@Override
	public int lateCharge() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Date returnDate() {
		// TODO Auto-generated method stub
		return getReturnDate();
	}

	@Override
	public Date borrowDate() {
		// TODO Auto-generated method stub
		return getBorrowDate();
	}

	@Override
	public Member discountOwner() {
		// TODO Auto-generated method stub
		return getMember();
	}

	@Override
	public String chargeType() {
		// TODO Auto-generated method stub
		return getItemType();
	}

	@Override
	public Priority priorityType() {
		// TODO Auto-generated method stub
		return getPriority();
	}

	

	

	

	


	
	
	

}
