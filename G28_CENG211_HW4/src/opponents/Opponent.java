package opponents;

import characters.Human;
import opponents.Opponent;
import utils.Utilities;
import weapon.Weapon;

public abstract class Opponent{
	public static int idCounter = 1;
	private int id;
	protected double points;
	protected double attackPoint;
	protected double speed;
	private boolean guardFlag = false;
	
	public Opponent() {
		initAttack();
		initId();
		initPoint();
		initSpeed();
	}
	public int hitToAnyHuman(double damage , Human<? extends Weapon> human) {
		return human.takeDamage(damage);
	}
	
	public abstract double specialAction(); 
	
	public double attack() {
		return attackPoint;
	}
	
	public int takeDamage(double damage) {
		if(guardFlag) {
			points -= Math.round(damage/2);
			return (int)Math.round(damage/2);
		}
		else {
			points -= Math.round(damage);
			return (int)Math.round(damage);
		}		
	}
	
	public void guard() {
		guardFlag = true;
	}
	
	private void initId() {
		id =idCounter;
		idCounter++;
	}
	private void initPoint() {
		points = Utilities.inclusiveRandomValueCreator(50, 150);
	}
	
	private void initAttack() {
		attackPoint = Utilities.inclusiveRandomValueCreator(5, 25);
	}
	
	private void initSpeed() {
		speed = Utilities.inclusiveRandomValueCreator(1, 90);
	}
	
	
	public int getIdCounter() {
		return idCounter;
		
	}
	
	public int getId() {
		return id;
	}

	public double getPoints() {
		return points;
	}

	public double getAttackPoint() {
		return attackPoint;
	}

	public double getSpeed() {
		return speed;
	}

	public boolean isGuardFlag() {
		return guardFlag;
	}
	public void setGuardFlag(boolean guardFlag) {
		this.guardFlag = guardFlag;
	}

	@Override
	public String toString() {
		return "id=" + id + 
				", Points=" + points + ", Attack=" + attackPoint + ", Speed=" + speed
				 ;
	}
	
	
	
}
