package characters;

import java.util.concurrent.atomic.AtomicInteger;

import weapon.Spear;
import weapon.Sword;
import weapon.Weapon;

public class Hunter<W extends Weapon> extends Human<W>{
	/*
	 * attack with modifier 0.5 and then pass the turn then 2 turn immediately
	*/
	private boolean isHunterWaitOneTour = false;
	public Hunter(String name) {
		super(name);
	}

	@Override
	public double specialAction() {
		try {
			specialAbilityCheck();
			specialAbilityRight = false;							
			return 0.5;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public boolean isHunterWaitOneTour() {
		return isHunterWaitOneTour;
	}

	public void setHunterWaitOneTour(boolean isHunterWaitOneTour) {
		this.isHunterWaitOneTour = isHunterWaitOneTour;
	}
	

	

}
