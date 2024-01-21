package opponents;

import characters.Human;
import weapon.Weapon;

public class Slime extends Opponent{

	private boolean increasePoint = false; 
	@Override
	public double specialAction() {
		increasePoint = true;
		return 1;
	}
	
	public int hitToAnyHuman(double damage , Human<? extends Weapon> human) {
		if(increasePoint) {
			points += damage;
			pointControl();
			increasePoint = false;
		}
		return super.hitToAnyHuman(damage, human);
	}
	
	private void pointControl() {
		if(points > 150)
			points = 150;
	}

	@Override
	public String toString() {
		return "Slime [" + super.toString() + "]";
	}
	
}
