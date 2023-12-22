package opponents;

public class Goblin extends Opponent{
	
	public Goblin(int opponentId) {
		super(opponentId);
		
	}
	
	@Override
	public void specialAction() {
		// it gets next turn immediately and attacks two times and both attacks dealts newAttackForTwice
		attack = 0.7 * attack;
		
	}
	@Override
	public String toString() {
		return "Type: Goblin [opponentId=" + opponentId + ", points=" + points + ", attack=" + attack + ", speed=" + speed
				+ "]";
	}
	
}
