package characters;

import weapon.Weapon;
import weapon.Weapon;
import weapon.Bow;
import weapon.Spear;
import weapon.Sword;

import java.util.Queue;
import java.util.Random;

import exceptions.InsufficientStaminaException;
import exceptions.SpecialAlreadyUsedException;
import opponents.Opponent;
import opponents.Opponent;
import utils.Utilities;

abstract public class Human<W extends Weapon> implements Character<W>{
	private String name;
	private double points;
	private double attackPoint;
	protected double stamina = 10 ;
	private double speed ;
	private W weapon;
	private boolean guardFlag = false;
	protected boolean specialAbilityRight = true; 
	
	
	
	public Human(String name ) {
		this.name = name;
		initAttack();
		initPoint();
		initRandomWeapon();
		initSpeed();
	}
	
	@SuppressWarnings("unchecked")
	private void initRandomWeapon() {
		switch (Utilities.inclusiveRandomValueCreator(1, 3)) {
		case 1:
			weapon = (W) new Bow();
			break;
		case 2:
			weapon = (W) new Spear();
			break;
		case 3:
			weapon = (W) new Sword();	
			break;
		}
	}
	
	private void initPoint() {
		points = Utilities.inclusiveRandomValueCreator(100, 150);
	}
	private void initAttack() {
		attackPoint = Utilities.inclusiveRandomValueCreator(20, 40);
	}
	private void initSpeed() {
		speed = Utilities.inclusiveRandomValueCreator(10, 99);
	}
	
	public int hitToAnyOpponent(Opponent opponent, int damage) {
		return opponent.takeDamage(damage);
	}
	
	@Override
	public double punch() {
		try {
			controlStamina(1);
			stamina--;
			return attackPoint*0.8;
			
		} catch (InsufficientStaminaException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public int takeDamage(double damage) {
		if(guardFlag) {
			points -= Math.round(damage/4);
			return (int)Math.round(damage/4);
		}
		else {
			points -= Math.round(damage);
			return (int)Math.round(damage);
		}		
	}
	
	@Override
	public <W extends Weapon> double attackWithWeapon(int choice) {
		try {
			if(weapon instanceof Bow ) {
				return bowChoices(choice);
			}
			else if(weapon instanceof Spear) {
				controlStamina(2);
				stamina -= 2;
				return spearChoices(choice);
			}
			else {
				controlStamina(2);
				stamina -= 2;
				return swordChoices(choice);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	private double bowChoices(int choice) throws InsufficientStaminaException {
		if(choice == 1) {
			controlStamina(1);
			stamina -= 1;
			return singleArrowWithBow();
			
		}
		else {
			controlStamina(3);
			stamina -= 3;
			return twoArrowWithBow();
			
		}	
	}
	
	private double spearChoices(int choice) {
		if(choice == 1)
			return stapWithSpear();
		else 
			return throwTheSpare();
		
	}
	
	private double swordChoices(int choice) {
		if(choice == 1)
			return slashWithSword();
		else 
			return stapWithSword();
	}
	
	private double singleArrowWithBow() {
		return 0.8*(attackPoint + weapon.getAdditionalAttack());
	}
	private double twoArrowWithBow() {
		return 2.5*(attackPoint + weapon.getAdditionalAttack());
	}
	private double slashWithSword() {
		return attackPoint + weapon.getAdditionalAttack();
	}
	private double stapWithSword() {
		if(Utilities.inclusiveRandomValueCreator(1, 100)>75) {
			return 2*(attackPoint + weapon.getAdditionalAttack());
		}
		else {return 0;}
	}
	
	private double stapWithSpear() {
		return 1.1*(attackPoint + weapon.getAdditionalAttack());
	}
	private double throwTheSpare() {
		return 2*(attackPoint + weapon.getAdditionalAttack());
	}

	@Override
	public void guard() {
		guardFlag = true;
		stamina +=3;
	}

	@Override
	public boolean run() {
		return true;
	}

	@Override
	public abstract double specialAction();
	
	
	private void controlStamina(int worthOfAction) throws InsufficientStaminaException {
		if(worthOfAction > stamina)
			throw new InsufficientStaminaException("The character can not perform that action because of stamina lack");
	}

	public String getName() {
		return name;
	}

	public double getPoints() {
		return points;
	}

	public double getAttackPoint() {
		return attackPoint;
	}

	public double getStamina() {
		return stamina;
	}

	public double getSpeed() {
		return speed;
	}

	public W getWeapon() {
		return weapon;
	}

	public boolean isGuardFlag() {
		return guardFlag;
	}

	public void setGuardFlag(boolean guardFlag) {
		this.guardFlag = guardFlag;
	}
	
	public void specialAbilityCheck() throws SpecialAlreadyUsedException {
		if(!specialAbilityRight)
			throw new SpecialAlreadyUsedException("This character have already used the special attack");
	}

	@Override
	public String toString() {
		return "name=" + name + " Type=" + this.getClass().getName().substring(11)+ ", points=" + points + ", attackPoint=" + attackPoint + ", stamina=" + stamina
				+ ", speed=" + speed  + "weapon = " + weapon.getClass().getName()
				+" with "+ weapon.getAdditionalAttack()+" attack" + "]" + "\n";
	}
	
	
	
}
