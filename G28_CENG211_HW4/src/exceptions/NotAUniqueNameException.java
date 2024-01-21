package exceptions;

@SuppressWarnings("serial")
public class NotAUniqueNameException extends Exception {
	
	public NotAUniqueNameException(String message) {
		super(message);
	}
}
