package exceptions;

@SuppressWarnings("serial")
public class InsufficientStaminaException extends Exception {
	
	public InsufficientStaminaException(String message, int leftStamina , int needStamina) {
		super(message + " Left Stamina: " + leftStamina + "Need Stamina: " + needStamina);
	}
	
	public InsufficientStaminaException(String message) {
		super(message);
	}
}
