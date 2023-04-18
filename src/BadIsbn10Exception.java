// -----------------------------------------------------
// Assignment 3
// Written by: Kateryna Gurina
// -----------------------------------------------------
/**
 * This exception class is used to indicate that an invalid ISBN-10 has been encountered.
 * This exception is thrown when the ISBN-10 is invalid, and includes a message that describes the problem.
 */

public class BadIsbn10Exception extends Exception{
	/**
     * @param message the detail message
     */
	public BadIsbn10Exception(String message) {
		super(message);
	}

}
