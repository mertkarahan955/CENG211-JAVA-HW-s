package members;

public class GeneralMember extends Member{
		
	public GeneralMember(String name) {
		super(name);
	discount = 0;
	}

	@Override
	public String toString() {
		return "GeneralMember [name=" + name + ", discount=" + discount + ", getName()=" + getName()
				+ ", getDiscount()=" + getDiscount() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
