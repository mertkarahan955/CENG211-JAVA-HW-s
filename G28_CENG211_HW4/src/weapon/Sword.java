package weapon;

public class Sword extends Weapon{

	
	
	
	public Sword() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double slash(int opponentAttackDamage) {
		return super.additionalAttack + opponentAttackDamage;
		
	}

	@Override
	public double stab(int opponentAttackDamage) {
		boolean temp = random.nextInt(4) == 0;
		if(temp) {
			return super.additionalAttack;
		}else {
			return 2 * (super.additionalAttack) + opponentAttackDamage; 
		}
	}

	@Override
	public String toString() {
		return "Sword [additionalAttack=" + additionalAttack + "]";
	}

}
