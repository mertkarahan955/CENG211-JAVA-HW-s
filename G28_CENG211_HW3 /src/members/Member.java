package members;

public abstract class Member {
	String name;
	double discount;

	public Member(String name) {
		discount = 0;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getDiscount() {
		return discount;
	}

	public String toString() {
		return "Member [name=" + name + ", discount=" + discount + "]";
	}
}
