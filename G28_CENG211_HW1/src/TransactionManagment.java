public class TransactionManagment {
	// Constructor
	
	
	private FileIO file = new FileIO(); // calling the file reader 
	Product[] productArray = file.ProductFileIOReader(); // assigning  products to array
	ShopAssistant[] assistantArray = file.AssistantFileIOReader(); // assigning assistants to array
	
	
	private Transaction[][] assistantsWTransaction = new Transaction[assistantArray.length][15]; // creating a 2-D for setting assistants to arrays
	private double[] totalSaleArray = new double[100]; // holding the each assistants total sale.
	private double totalSales;
	private double totalSale = getTotalSales();
	private double commissionFee = 0.01 * totalSale;
	
	 // constructor
		public TransactionManagment() {
			setTheTransactionsToAssistants();
			totalSaleArray = calculateAssistantTransaction();
		}
	//*************************************************METHODS***********************
		
	// setting each 15 transactions to specific assistants
	private Transaction[][] setTheTransactionsToAssistants() {
	    for (int i = 0; i < assistantsWTransaction.length; i++) {
	    	int assistantIndex = 0;
	        for (int j = 0; j < 15; j++) {
	        	
	            if (assistantIndex <assistantArray.length) {
	            	assistantsWTransaction[i][j] = new Transaction(productArray);    
	            }
	            assistantIndex++;
	        }
	    }
	    return assistantsWTransaction;
	}
	public Transaction[][] getAssistantsWTransaction() {
		return assistantsWTransaction;
	}
	// calculating the total sales of 15 transactions for 1 assistant.
	private double[] calculateAssistantTransaction() {
		for(int i = 0; i< totalSaleArray.length; i++) {
			for (int j = 0; j<15; j++) {
				totalSaleArray[i] += assistantsWTransaction[i][j].getTotalPrice();
			}
		}
		return totalSaleArray;
	}
	// calculating commission fee with respect to Assistant's total Sale.
	public double calculateCommissionFee(int i) {
		if(totalSaleArray[i] >= 7500) {
			commissionFee = totalSaleArray[i]*0.03;
	}
		else {
			commissionFee = totalSaleArray[i]*0.01;
		}
		return commissionFee;
}
	public double getCommissionFee() {
		return commissionFee;
}
	public double getTotalSales() {
		return totalSales;
	}
	
}

