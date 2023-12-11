package functions;
import java.util.concurrent.TimeUnit;
import interfaces.Borrowable;

public class Borrower {
	
	public Borrower(){}
	// calculating borrowing price assuming no late fee.
	 private double borrowingPrice(Borrowable borrowable) {
		 double borrowingPrice = 0;
		if(borrowable.chargeType().equalsIgnoreCase("book")) {
			borrowingPrice = borrowedDay(borrowable) * dailyChargeAmount(borrowable) * borrowable.priorityType().getValue();
		}
		else if(borrowable.chargeType().equalsIgnoreCase("magazine")) {
			borrowingPrice = borrowedDay(borrowable) * dailyChargeAmount(borrowable) * borrowable.priorityType().getValue();
		}
		return borrowingPrice;
	}
	// checking the type for giving the charge amount
	 private int lateCharge(Borrowable borrowable) {
		 int charge = 0;
		if(borrowable.chargeType().equalsIgnoreCase("book")) {
			if(borrowedDay(borrowable) > 10) {
				charge =  5;
			}
		}
		else if(borrowable.chargeType().equalsIgnoreCase("magazine")) {
			if(borrowedDay(borrowable) > 7) {
				charge =  2;
			}
		}
		return charge;
	}
	 // this method is for calculating the borrowed day.
	 private int borrowedDay(Borrowable borrowable) {
		long diffInMillies = Math.abs(borrowable.returnDate().getTime() - borrowable.borrowDate().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
     
        return (int) diffInDays;

	}
	
	private int dailyChargeAmount(Borrowable borrowable) {
		if(borrowable.chargeType().equalsIgnoreCase("book")) {
			return 5;
		}
		else if (borrowable.chargeType().equalsIgnoreCase("magazine")) {
			return 10;
		}
		else {
			return 0;
		}
	}
	// using borrowingPrice, late charge and discount
	public double calcTotalFee(Borrowable borrowable) {
		return  (borrowingPrice(borrowable) + lateCharge(borrowable))*(1 - borrowable.discountOwner().getDiscount()); // add discount
	}
	
	// checking exceeds or not exceeds
	public String checkExceed(Borrowable borrowable) {
		if(borrowable.chargeType().equalsIgnoreCase("book")) {
			if(borrowedDay(borrowable) > 10) {
				return "Exceeds";
			}
			else {
				return "Not Exceeds";
			}
		}
		else if(borrowable.chargeType().equalsIgnoreCase("magazine")) {
			if(borrowedDay(borrowable) > 7) {
				return "Exceeds";
			}
			else {
				return "Not Exceeds";
			}
		}
		return "check";
	}
	
}
