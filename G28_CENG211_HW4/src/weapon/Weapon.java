package weapon;

import java.util.Random;

import utils.Utilities;

abstract public class Weapon{
private double additionalAttack;
	
	{
		initAdditionalAttack();
	}
	private void initAdditionalAttack() {
		additionalAttack = Utilities.inclusiveRandomValueCreator(10, 20);
	}
	
	public double getAdditionalAttack() {
		return additionalAttack;
	}
	
	
	
}
