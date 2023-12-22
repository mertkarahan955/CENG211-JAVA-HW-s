package interfaces;

import human_characters.Human;
import weapon.Weapon;

public interface Character<W> {
	public double punch();
	public double attackWithWeapon(String attackType, Human<Weapon> obj);
	public double guard(double consumedAttack);
	public void run();
	public double specialAction();
	
}
