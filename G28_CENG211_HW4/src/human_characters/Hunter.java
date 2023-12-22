package human_characters;

import java.util.concurrent.atomic.AtomicInteger;

import weapon.Spear;
import weapon.Sword;
import weapon.Weapon;

public class Hunter extends Human{
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
	public Hunter() {
		super();
		id = 2;
	}
	public Hunter(String name) {
		this.name = name;
		this.id = ID_GENERATOR.getAndIncrement();
	}
	public Hunter(String name, int id) {
		this.name = name;
		this.id = ID_GENERATOR.getAndIncrement();
	}
	
	@Override
	public double specialAction() {
		double tempHit = 0;
		while(getSpecialActionCounter() > 0) {
			setSpecialActionCounter();
			tempHit = 0.5 * getAttack();
		}
		return tempHit;
		
	}

	@Override
	public String toString() {
		return "Hunter ["+ super.toString() + "]";
	}

	

	



	


}
