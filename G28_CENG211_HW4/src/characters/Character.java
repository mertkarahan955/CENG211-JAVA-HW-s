package characters;

import exceptions.InsufficientStaminaException;
import weapon.Weapon;


public interface Character<W> {
	public double punch() throws InsufficientStaminaException;
	public <W extends Weapon> double attackWithWeapon(int choice);
	public void guard();
	public double specialAction(); // it determines the attack modifier attribute
	public boolean run();
	
}
