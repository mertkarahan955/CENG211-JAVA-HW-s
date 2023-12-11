package members;

public abstract class Student extends Member{
	
	String name; 
	public Student(String name) {
		super(name);
		discount = 0.2;
		
	}
		
	public String toString() {
		return "Student [name=" + name + ", discount=" + discount + ", getName()=" + getName() + ", getDiscount()="
				+ getDiscount() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}
}