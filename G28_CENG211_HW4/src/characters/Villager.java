package characters;

import weapon.Weapon;

public class Villager<W extends Weapon> extends Human<W>{
	public Villager(String name) {
		super(name);
		specialAbilityRight = false;
	}

	@Override
	public double specialAction() {
		System.out.println("Villager does not have any special power");
		return -1; // -1 meaning speacial action can not performed.
	}
	

}
