package weapon;

public class Bow extends Weapon{

	
	public Bow() {
		super();
	}
	
	
	
	@Override
	public double slash(int opponentAttackDamage) {
		return 0.8 * (super.additionalAttack + opponentAttackDamage);
		// single 
	}

	@Override
	public double stab(int opponentAttackDamage) {
		return 2.5 * (super.additionalAttack + opponentAttackDamage);
		// double
	}



	@Override
	public String toString() {
		return "Bow [additionalAttack=" + additionalAttack + "]";
	}

}
