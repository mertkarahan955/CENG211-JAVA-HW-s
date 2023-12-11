package members;

public class ScholarShipStudent extends Student{
	
	public ScholarShipStudent(String name) {
		super(name);
		discount = 0.3;
	}

	@Override
	public String toString() {
		return "ScholarShipStudent [name=" + name + ", discount=" + discount + ", toString()=" + super.toString()
				+ ", getName()=" + getName() + ", getDiscount()=" + getDiscount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
	

