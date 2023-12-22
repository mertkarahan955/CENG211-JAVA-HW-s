package human_characters;

import java.util.concurrent.atomic.AtomicInteger;

import weapon.Weapon;

public class Squire extends Human{
	int specialStamina = 0;
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
	
	public Squire() {
		super();
	}
	public Squire(String name) {
		this.name = name;
		id = ID_GENERATOR.getAndIncrement();
	}
	public Squire(String name, int id) {
		this.name = name;
		this.id = ID_GENERATOR.getAndIncrement();
	}

	@Override
	public double specialAction() {
		double tempHit = 0;
		id = 3;
		while(getSpecialActionCounter()>0) {
			setSpecialActionCounter();
			tempHit = 0.5 * getAttack();
			setStamina();
			
		}
		return tempHit;
	}

		private int setStamina() {
			specialStamina = getStamina() + 10;
			return specialStamina;
		}

		@Override
		public String toString() {
			return "Squire [" + super.toString() + "]";
		}	
	
}
