
public class ProgramExecuter {
	
	public void run() {
		Query query = new Query();
		query.highestValueTransaction();
		System.out.println("***********************");
		System.out.println();System.out.println();
		query.expProdAtMinPriceTransaction();
		System.out.println("***********************");
		System.out.println();System.out.println();
		query.minTransactionFee();
		System.out.println("***********************");
		System.out.println();System.out.println();
		query.highSalAssistant();
		System.out.println("***********************");
		System.out.println();System.out.println();
		query.totalRevenue();
		System.out.println("***********************");
		System.out.println();System.out.println();
		query.lastTotalProfit();
		System.out.println("***********************");
	}
}
