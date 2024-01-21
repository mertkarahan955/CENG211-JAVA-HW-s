package tbGame;

public class Turn {
	private String title ;
	private double attackModifier = 1;
	private int speed;
	
	public Turn(String title, int speed) {
		this.title = title;
		this.speed = speed;
	}

	public double getAttackModifier() {
		return attackModifier;
	}

	public void setAttackModifier(double attackModifier) {
		this.attackModifier = attackModifier;
	}

	public String getTitle() {
		return title;
	}
	
	public int getSpeed() {
		return speed;
	}

	@Override
	public String toString() {
		return title + ", " ;
	}

	
	
	
}
