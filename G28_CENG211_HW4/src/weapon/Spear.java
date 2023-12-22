package weapon;

public class Spear extends Weapon {

	
	
	
	public Spear() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double slash(int opponentAttackDamage) {
		return 2 * (super.additionalAttack + opponentAttackDamage);
		// thrown
	}

	@Override
	public double stab(int opponentAttackDamage) {
		
		return 1.1 * (super.additionalAttack + opponentAttackDamage);
	}

	@Override
	public String toString() {
		return "Spear [additionalAttack=" + additionalAttack + "]";
	}

}
