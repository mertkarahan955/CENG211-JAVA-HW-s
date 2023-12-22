package human_characters;

import java.util.concurrent.atomic.AtomicInteger;

import weapon.Weapon;

public class Knight extends Human {
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
	public Knight() {
		
		super();
		id = 1;
		
	}
	public Knight(String name) {
		this.name = name;
		
	}
	public Knight(String name, int id) {
		this.name = name;
		this.id = ID_GENERATOR.getAndIncrement();
	}
	

	@Override
	public double specialAction() {
		double tempHit = 0;
		while(getSpecialActionCounter() > 0) {
			 setSpecialActionCounter();
			  tempHit = super.getAttack() * 3;
			 
		}
		return tempHit;
		
			
		
		
	}




	@Override
	public String toString() {
		return "Knight [" + super.toString() + "]";
	}


}
