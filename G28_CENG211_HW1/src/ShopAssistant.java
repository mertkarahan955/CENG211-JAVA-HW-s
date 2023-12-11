import java.util.Objects;
import java.util.Random;

public class ShopAssistant {
    private String id;
    private String assistantName;
    private String assistantSurname;
    private String phoneNumber;
    private int seniority;
    private double salary;
 
 
   
    
    
    
    
   
    
    
    // Constructor
    public ShopAssistant(String id, String assistantName, String assistantSurname, String phoneNumber) {
        this.id = id;
        this.assistantName = assistantName;
        this.assistantSurname = assistantSurname;
        this.phoneNumber = phoneNumber;
        calculateSeniority();
    	calculateSenioritySalary();
    	
    	
    	
    }
    
    public double getSalary() {
		return salary;
	}
    
    public int getSeniority() {
		return seniority;
	}
    // selecting random integer for setting the seniority of assistants.
	private void calculateSeniority() {
		Random random = new Random();
		int temp = random.nextInt(15);
		seniority = temp;
	}
	// calculating the salary of assistants with respect to seniority.
	private void calculateSenioritySalary() {
		if (seniority < 1) {
			salary = 6000;
		}
		else if (1 <=seniority && seniority< 3) {
			salary = 8000;
		}
		else if (3<= seniority && seniority < 5) {
			salary = 10000;
		}
		else {
			salary =12000;
		}
		}
	
    public String getId() {
        return id;
    }
    public String getAssistantName() {
        return assistantName;
    }
    public String getAssistantSurname() {
        return assistantSurname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    
	public int hashCode() {
		return Objects.hash(assistantName, assistantSurname, id, phoneNumber);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopAssistant other = (ShopAssistant) obj;
		return Objects.equals(assistantName, other.assistantName)
				&& Objects.equals(assistantSurname, other.assistantSurname) && Objects.equals(id, other.id)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}
	public String toString() {
		return "ShopAssistant [id=" + id + ", assistantName=" + assistantName + ", assistantSurname=" + assistantSurname
				+ ", phoneNumber=" + phoneNumber +  " seniority= " +  seniority ;
	}	
	//  seniority weekly basis salary commission and total salary 
 }
  