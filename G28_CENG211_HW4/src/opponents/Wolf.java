package opponents;

import java.util.ArrayList;
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
	
	public void specialAction(ArrayList<Opponent> opponentList) {
		if(getRandom().nextInt(5) == 0) {
			opponentList.add(new Wolf());
		}
		
	}
	@Override
	public String toString() {
		return "Type: Wolf [opponentId=" + opponentId + ", points=" + points + ", attack=" + attack + ", speed=" + speed
				+ "]";
	}
}
