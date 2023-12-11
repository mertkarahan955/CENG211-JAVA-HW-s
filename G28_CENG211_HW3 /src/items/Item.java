package items;
import java.text.SimpleDateFormat;
import java.util.Date;

import enums.Priority;
import interfaces.Borrowable;
import interfaces.Searchable;
import members.Member;

public abstract class Item implements Borrowable, Searchable{
	
	private String number;
	private String title;
	private Priority priority;
	private String itemType;
	private String author;
	private String publisher;
	private Member member;
	private Date borrowDate;
	private Date returnDate;
	
	public Item(String number, String title, Priority priority, String itemType,String author, String publisher, Member member,
			Date borrowDate, Date returnDate) {
		this.number = number;
		this.title = title;
		this.priority = priority;
		this.itemType = itemType;
		this.author = author;
		this.publisher = publisher;
		this.member = member;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public String toString() {
		return "Item [number=" + number + ", priority=" + priority + ", itemType=" + itemType + ", author=" + author
				+ ", publisher=" + publisher + ", member=" + member + ", borrowDate=" + borrowDate + ", returnDate="
				+ returnDate + "]";
	}

	public String getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public Priority getPriority() {
		return priority;
	}

	public String getItemType() {
		return itemType;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public Member getMember() {
		return member;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}
	// New method with the same name, returning String
	public String borrowDateAsString() {
	    // Convert the Date to String using a desired format
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    Date date = getBorrowDate();
	    return dateFormat.format(date);
	}
	public String returnDateAsString() {
	    // Convert the Date to String using a desired format
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    Date date = getReturnDate();
	    return dateFormat.format(date);
	}

	
}
	

