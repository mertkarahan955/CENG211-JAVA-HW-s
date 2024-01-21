package opponents;

public class Goblin extends Opponent{
	
	private boolean isGoblinWaitOneTour = false;
	@Override
	public double specialAction() {
		return 0.7;
		
	}
	
	public boolean getIsGoblinWaitOneTour() {
		return isGoblinWaitOneTour;
	}
	public void setIsGoblinWaitOneTour(boolean bool) {
		isGoblinWaitOneTour = bool;
	}

	@Override
	public String toString() {
		return "Goblin [" + super.toString() + "]";
	}
	
}
