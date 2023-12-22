package weapon;

import java.util.Random;

abstract public class Weapon{
	int additionalAttack; // [10,20]
	
	
	Random random = new Random();
	
	public Weapon() {
		
		additionalAttack = (1 + random.nextInt(20));
	}
	
	public abstract double stab(int opponentAttackDamage);
	public abstract double slash(int opponentAttackDamage);

	@Override
	public String toString() {
		return "Weapon [additionalAttack=" + additionalAttack + "]";
	}
	
	
	
	
}
