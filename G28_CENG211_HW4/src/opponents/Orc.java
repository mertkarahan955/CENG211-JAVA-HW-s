package opponents;

public class Orc extends Opponent{

	public Orc(int opponentId) {
		super(opponentId);
		
		}
	
	public void specialAction() {
		// double attack for once then give its turn. 
		attack *= attack;
	}
	@Override
	public String toString() {
		return "Type :Orc [opponentId=" + opponentId + ", points=" + points + ", attack=" + attack + ", speed=" + speed + "]";
	}

}
