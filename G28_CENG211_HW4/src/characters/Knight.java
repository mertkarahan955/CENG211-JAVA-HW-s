package characters;
import weapon.Weapon;

public class Knight<W extends Weapon> extends Human<W> {
	/*
	 * pass the current round and then attack with modifier 3.
	*/
	
	public Knight(String name) {
		super(name);
	
	}

	@Override
	public double specialAction() {
		try {
			specialAbilityCheck();
			specialAbilityRight = false;
			return 0;
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	
	
}
