import java.util.Objects;
import java.util.Random;

public class Product {
    private String id;
    private String productName;
    private double price;
    private int amount;
    private double  totalPrice;
    
    // Constructor
    public Product(String id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        addRandomAmount();
    }
    //*****************************************METHODS*************************
    
    private void addRandomAmount() {
		Random random = new Random();
		
		amount = random.nextInt(10) + 1;
		
	}
    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
    	totalPrice = price*amount;
    	
    	return totalPrice;
    }

	public int hashCode() {
		return Objects.hash(id, price, productName);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productName, other.productName);
	}

	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price +   " totalPrice= " + totalPrice + "]";
	}
    
	
	
    
   
}
