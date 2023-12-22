package opponents;

public class Slime extends Opponent{

	public Slime() {
		super();
		opponentId = 3;
	}
	public Slime(int opponentId) {
		this.opponentId = opponentId;
	}
	@Override
	public void specialAction() {
		double pointAfterAbsorb = getAttack();
		if(getPoints() + pointAfterAbsorb <= 150) {
			 points += pointAfterAbsorb;
		}
		else {
			pointAfterAbsorb = 150;
			System.out.println("Your health limit is up to 150. So your new health setted to 150");
		}
		
		
		
	}
	@Override
	public String toString() {
		return "Type: Slime [opponentId=" + opponentId + ", points=" + points + ", attack=" + attack + ", speed=" + speed
				+ "]";
	}

}
