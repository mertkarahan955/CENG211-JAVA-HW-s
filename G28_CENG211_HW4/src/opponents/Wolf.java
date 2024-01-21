package opponents;

import opponents.Wolf;

public class Wolf extends Opponent{
	@Override
	public double specialAction() { 
		return 0;
		
	}
	public Wolf() {
		
	}
	public Wolf(Wolf wolf) {
		speed = wolf.speed;
		attackPoint = wolf.attackPoint;
		points = wolf.points;
	}
	
	public Wolf returnNewWolf() {
		return new Wolf(this);
	}
	@Override
	public String toString() {
		return "Wolf [" + super.toString() + "]";
	}
}
