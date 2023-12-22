package opponents;

import java.util.Random;

import app.GamePlayers;
import human_characters.Human;

public abstract class Opponent implements GamePlayers {
	int opponentId;
	int tempId = 0;
	protected double points;
	protected double attack;
	protected double speed;
	Random random = new Random();
	public Opponent() {}
	public Opponent(int opponentId) {
		this.opponentId = opponentId;
		points = random.nextInt(50, 151);
		attack = random.nextInt(5, 25);
		speed = random.nextInt(1,90);

	}

	public  double attack(int randomAttackId, Human[] human) {
		attack = human[randomAttackId].getAttack();
		return attack;
	}  
	
	public double guard(Human opponent) {
		// do nothings on that round and gets half damage from its opponent
		return opponent.getAttack() * 0.5;
	}
	// overriding in subclasses and overloading if it necessary
	public abstract void specialAction();
	
	
	
	public int getOpponentId() {
		return opponentId;
	}
	public String getName() {
	    return "" + opponentId;
	}

	public double getPoints() {
		return points;
	}

	public double getAttack() {
		return attack;
	}

	public double getSpeed() {
		return speed;
	}

	public Random getRandom() {
		return random;
	}
	@Override
	public String toString() {
		return "Opponent [opponentId=" + opponentId + ", points=" + points + ", attack=" + attack + ", speed=" + speed
				+ "]";
	}
	

}
