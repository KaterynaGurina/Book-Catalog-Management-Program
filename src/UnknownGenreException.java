/**
 * This exception is thrown when the genre of the record is unknown.
*/
public class UnknownGenreException extends Exception {
	public UnknownGenreException(String message) {
		super(message);
	}
}
