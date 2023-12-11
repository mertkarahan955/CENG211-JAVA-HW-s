
public class Query {	
	private TransactionManagment transactionManagment = new TransactionManagment();
	private SalaryManagment salaryManagment = new SalaryManagment();
	
	// The highest-total-price transaction.
	public void highestValueTransaction() {
		double temp = 0;
		String id = "";
		for (int i = 0; i < transactionManagment.getAssistantsWTransaction().length; i++) {
			for (int j = 0; j < transactionManagment.getAssistantsWTransaction()[i].length; j++) {
				if(transactionManagment.getAssistantsWTransaction()[i][j].getTotalPrice() > temp) {
					
					id = transactionManagment.getAssistantsWTransaction()[i][j].toString();	
				}
			}
		}
		System.out.println("Highest value transaction is: " + id);
	}
	//The most expensive product in the lowest-price transaction.
	public void expProdAtMinPriceTransaction() {
		double temp = transactionManagment.getAssistantsWTransaction()[0][0].getTotalPrice();
		Product product = null;
		int id = 0;
		for (int i = 0; i < transactionManagment.getAssistantsWTransaction().length; i++) {
			for (int j = 0; j < transactionManagment.getAssistantsWTransaction()[i].length; j++) {
				if(transactionManagment.getAssistantsWTransaction()[i][j].getTotalPrice() < temp) {
					temp = transactionManagment.getAssistantsWTransaction()[i][j].getTotalPrice();
					product = transactionManagment.getAssistantsWTransaction()[i][j].expProductInCheapTransaction();
				}
			}
		}
		System.out.println("The most expensive product in the lowest-price transaction is: " + product.getProductName()  );
	}
	// The lowest transaction fee.
	public void minTransactionFee() {
		double temp = transactionManagment.getAssistantsWTransaction()[0][0].getTransactionFee();;
		
		for (int i = 0; i < transactionManagment.getAssistantsWTransaction().length; i++) {
			for (int j = 0; j < transactionManagment.getAssistantsWTransaction()[i].length; j++) {
				if(transactionManagment.getAssistantsWTransaction()[i][j].getTransactionFee() < temp) {
					temp = transactionManagment.getAssistantsWTransaction()[i][j].getTransactionFee();
					
				}
			}
		}
		System.out.println("The lowest transaction fee is: " + temp);
	}
	// The highest-salary shop assistant.
	public void highSalAssistant() {
		double temp = 0;
		int id = 0;
		double temp2 = 0; 
		for (int i = 0; i < salaryManagment.getAssistantSalaries().length; i++) {
			if(salaryManagment.getAssistantSalaries()[i] > temp) {
				temp = salaryManagment.getAssistantSalaries()[i];
				temp2 = salaryManagment.getCommissionFees()[i];
				id = i;	
			}
		}
		System.out.println("Highest salary assistant is: " + transactionManagment.assistantArray[id].toString() + " commissionFee= " + temp2 + " finalSalary= " + temp +"]");
	}
	// The total revenue that is earned from 1500 transactions including both total price and
	// transaction fee of each transaction.
	public void totalRevenue() {
		double temp = 0;		
		double totalRevenue = 0;
		for (int i = 0; i < transactionManagment.getAssistantsWTransaction().length; i++) {
			for (int j = 0; j < transactionManagment.getAssistantsWTransaction()[i].length; j++) {
				temp += transactionManagment.getAssistantsWTransaction()[i][j].getTotalPrice();
			}
		}
		totalRevenue = temp;
		System.out.println("Total revenue is: " + totalRevenue);		
	}
	// The total profit that is earned after paying the shop assistant salaries.
	public void lastTotalProfit() {
		double temp = 0;
		double lastProfit = 0;
		for (int i = 0; i < transactionManagment.getAssistantsWTransaction().length; i++) {
			for (int j = 0; j < transactionManagment.getAssistantsWTransaction()[i].length; j++) {
				temp += transactionManagment.getAssistantsWTransaction()[i][j].getTotalPrice();		
			}	
		}
		lastProfit = temp - salaryManagment.getTotalSalary();
		System.out.println("Last profit is is: " + lastProfit);	
	}
}
