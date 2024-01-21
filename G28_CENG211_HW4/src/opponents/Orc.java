package opponents;

public class Orc extends Opponent{

	@Override
	public double specialAction() {
		return 2;
		
	}

	@Override
	public String toString() {
		return "Orc [" + super.toString() + "]";
	}
	
}
