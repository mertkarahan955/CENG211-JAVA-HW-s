package opponents;

public class Orc extends Opponent{

	public Orc() {
		super();
		opponentId =2;
		}
	public Orc(int opponentId) {
		this.opponentId = opponentId;
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
