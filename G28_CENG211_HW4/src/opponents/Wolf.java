package opponents;

import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Opponent{
	public Wolf(){
		super();
	}
	public Wolf(int opponentId) {
		super(opponentId);
		
	}
	
	@Override
	public void specialAction() {
	}
	
	public Wolf specialAction(Opponent[] opponentList) {
		if(getRandom().nextInt(5) == 0) {
			return new Wolf();
		}
		else {
			return null;
		}
	}
	@Override
	public String toString() {
		return "Type: Wolf [opponentId=" + opponentId + ", points=" + points + ", attack=" + attack + ", speed=" + speed
				+ "]";
	}
}
