package items;
import java.util.Date;
import enums.Priority;
import members.Member;

public class Magazin extends Item{

	public Magazin(String number, String title, Priority priority,String itemType, String author, String publisher, Member member,
			Date borrowDate, Date returnDate) {
		super(number, title, priority, itemType, author, publisher, member, borrowDate, returnDate);
		
	}
	public String toString() {
		return "Magazin [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	@Override
	public int lateCharge() {
		
		return 2;
	}
	@Override
	public Date returnDate() {
		
		return getReturnDate();
	}
	@Override
	public Date borrowDate() {
		
		return getBorrowDate();
	}
	@Override
	public Member discountOwner() {
		
		return getMember();
	}
	@Override
	public String chargeType() {
		
		return getItemType();
	}
	@Override
	public Priority priorityType() {
		
		return getPriority();
	}
}