import java.util.Arrays;
import java.util.Random;

public class Transaction {
	private static int STATIC_ID = 0 ;
    private double totalPrice; // total price after free
    private  double transactionFee;
    private double total = 0; // total price just summation of 3  products
    private int id=0;
    
    Product[] productInTransaction = new Product[3];
    
    // Constructor
    public Transaction(Product[] productArray) {
    	id = STATIC_ID;
    	STATIC_ID++;
    	pickThreeProduct(productArray);
        totalPriceWOFeeCalculator(productInTransaction); 
        transactionFeeCalculator();
        getTransactionFee();
        getTotalPrice();
    }
  //*************************************************METHODS***********************
    public double getTotal() {
		return total;
	}
    public int getId() {
    	return id;
    }
    
    public Product expProductInCheapTransaction() {
    	double temp = 0;
    	Product product = null;
    	for(int i = 0; i< productInTransaction.length; i++) {
    		if(productInTransaction[i].getPrice() > temp) {
    			temp = productInTransaction[i].getPrice();
    			product = productInTransaction[i];
    		}
    	}
    	return product;
    	 
    }
    // selecting 3 random products from productArray.
    private void pickThreeProduct(Product[] productArray) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            if (productArray.length > 0) {
                int temp = random.nextInt(productArray.length);
                productInTransaction[i] = productArray[temp];
            }
        }
    }
    // calculating the total price of just one transaction but without fee.
    private double totalPriceWOFeeCalculator(Product[] productInTransaction) {
        
        for(int i = 0; i<productInTransaction.length; i++) {
        	
        	total += productInTransaction[i].getPrice();
        	
        }
        return total;
    }
    // calculating the transaction fee.
    private double transactionFeeCalculator() {
    	if (total <= 499) {
            transactionFee = total * 1 / 100.0; 
        } else if (total >= 500 && total <= 799) {
            transactionFee = total * 3 / 100.0; 
        } else if (total >= 800 && total<= 999)  {
            transactionFee = total * 5 / 100.0; 
        } else if (total >= 1000) {
            transactionFee = total * 9 / 100.0; 
        }
        return transactionFee;
    }
       
    public double getTransactionFee() {
        return transactionFeeCalculator();
    }
     
    // calculating the total price which they are transaction fee and price
    public double getTotalPrice() {
    	totalPrice = transactionFeeCalculator()+ total;
    	return totalPrice ;
    }
	
	public String toString() {
		return "Transaction [ " + " id=" + id + " totalPrice=" + totalPrice + 
				  ", productInTransaction=" + Arrays.toString(productInTransaction)
				+ "]";
	}
    
    
    
    
    

   
    
}


