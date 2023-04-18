// -----------------------------------------------------
// Assignment 3 Part 1
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------
/**
 * This exception is thrown when there are too few fields in a record.
*/
public class TooFewFieldsException extends Exception {
	public TooFewFieldsException(String message) {
		super(message);
	}
}