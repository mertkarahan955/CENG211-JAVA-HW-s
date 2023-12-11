package members;

public class NormalStudent extends Student{

	public NormalStudent(String name) {
		super(name);
		super.discount = 0.2;
	}

	public String toString() {
		return "NormalStudent [name=" + name + ", discount=" + discount + ", toString()=" + super.toString()
				+ ", getName()=" + getName() + ", getDiscount()=" + getDiscount() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
