package human_characters;

import weapon.Weapon;
import weapon.Bow;
import weapon.Spear;
import weapon.Sword;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import interfaces.Character;

abstract public class Human<W extends Weapon> implements Character<W>{
	protected int id;
	protected String name;
	private int points; // [100,150]
	private int stamina; // always start at 10
	private int attack; // [20,40]
	private int speed; // [10,99]
	private Weapon weapon;
	private int specialActionCounter;
	
	Random random = new Random();
	public Human() {
		points = random.nextInt(100, 151);
		stamina = 10;
		attack = random.nextInt(20,41);
		speed = random.nextInt(10, 100); 
		specialActionCounter = 1;
		weapon = initializeWeapon();
	}
	public Human(String name, int id) {
		this();
	}
	
	@Override
	public double punch() {
		stamina -= 1;
		return 0.8 * attack;
	}
  
	public double attackWithWeapon(String attackType, Human<Weapon> obj) {
		if(weapon.equals(Sword.class) && weapon.equals(Spear.class)) {
			obj.stamina -= 2;
		}
		double attackPower = attack;
		switch (attackType) {
		case "1":
			attackPower = weapon.slash(attack);
			break;
		case "2":
			attackPower = weapon.stab(attack);
			break;
			
		default:
			System.out.println("wrong attack type number");
			break;
		}
		return attackPower;
		
	}
	
		
	
	
	
	@Override
	public double guard(double consumedAttack) {
		double consumedAttackAfterGuard = consumedAttack * 0.25 ;
		
		return points - consumedAttackAfterGuard;
	}
	@Override
	public void run() {
		// finish the program.
//		Your character(s) started running away. The battle ends!
//		Thanks for playing!
	}
	
	

	@SuppressWarnings("unchecked")
	private Weapon initializeWeapon() {
		int randomValue = random.nextInt(3);
		
		switch (randomValue) {
		case 0: 
			weapon = (W) new Sword();
			
			break;
		case 1:
			weapon = (W) new Spear();
			break;
		case 2:
			weapon = (W) new Bow();
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + randomValue);
		}
		return weapon;
				}
	
	

	public int getName() {
		return id;
	}

	public int getPoints() {
		return points;
	}

	public int getStamina() {
		return stamina;
	}

	public int getAttack() {
		return attack;
	}

	public int getSpeed() {
		return speed;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public int getSpecialActionCounter() {
		return specialActionCounter;
	}
	public int setSpecialActionCounter() {
		return specialActionCounter--;
	}

	public Random getRandom() {
		return random;
	}

	@Override
	public String toString() {
		return "[" + name + ", points=" + points + ", stamina=" + stamina + ", attack=" + attack + ", speed="
				+ speed + ", weapon=" + weapon + "]";
	}
	
	
	
	
	
	
}
