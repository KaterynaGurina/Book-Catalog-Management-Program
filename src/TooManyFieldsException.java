/**
 * This exception is thrown when there are too many fields in a record.
*/
public class TooManyFieldsException extends Exception {
	public TooManyFieldsException(String message) {
		super(message);
	}
}