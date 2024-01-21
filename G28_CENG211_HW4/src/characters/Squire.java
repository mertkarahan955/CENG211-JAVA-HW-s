package characters;

import weapon.Weapon;

public class Squire<W extends Weapon> extends Human<W>{
	/*
	 * attack in turn with 0.5 and increase stamina to 10.
	*/
	public Squire(String name) {
		super(name);
	}

	@Override
	public double specialAction() {
		try {
			specialAbilityCheck();
			stamina = 10;
			specialAbilityRight = false;
			return 0.5;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
	}
	
	
}
