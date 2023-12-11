public class SalaryManagment {
    
	private TransactionManagment transactionManagment = new TransactionManagment();
    private double[] salaries = new double[100]; // salary for each assistant (fee + seniority salary).
    private double totalSalary; // total salary of all assistants
    private double[] commissionFees = new double[100]; // keeping the commissionFees for all assistants
    
   
	public SalaryManagment() {
		getCommissionFees();
    	getAssistantSalaries();
    	calculateTotalSalary();
    }
	// this method holds the all commissionFees.
	public double[] getCommissionFees() {
		for ( int i = 0; i < transactionManagment.assistantArray.length  ; i++) {
			commissionFees[i] = transactionManagment.calculateCommissionFee(i);
		}
		return commissionFees;
	}
	// this method holds the assistant salaries.
    public double[] getAssistantSalaries() {
    	for (int i = 0; i < transactionManagment.assistantArray.length  ; i++) {
			salaries[i] = (transactionManagment.assistantArray[i].getSalary() + transactionManagment.calculateCommissionFee(i));
		}
    	return salaries;
    }
   
    public double[] getSalaries() {
		return salaries;
	}
    
    private double calculateTotalSalary() {
    	double temp = 0;
    	for (int i = 0; i < salaries.length; i++) {
			temp += salaries[i];
		}
    	totalSalary = temp;
    	return totalSalary;
    }

	public double getTotalSalary() {
		return totalSalary;
	}

	
	
    
}
