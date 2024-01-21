package exceptions;

@SuppressWarnings("serial")
public class SpecialAlreadyUsedException extends Exception {
	
	public SpecialAlreadyUsedException(String message) {
		super(message);
	}
	
}
