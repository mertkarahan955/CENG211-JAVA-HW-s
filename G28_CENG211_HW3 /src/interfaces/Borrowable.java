package interfaces;
import java.util.Date;

import enums.Priority;
import members.Member;

public interface Borrowable {
	public int lateCharge();
	public Date returnDate();
	public Date borrowDate();
	public String borrowDateAsString();
	public String returnDateAsString();
	public Member discountOwner();
	public String chargeType();
	public Priority priorityType();
	public String getNumber();
}
