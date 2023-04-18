// -----------------------------------------------------
// Assignment 3
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------

/**
 * This exception class is used to indicate that an invalid ISBN-13 has been encountered.
 * This exception is thrown when the ISBN-13 is invalid, and includes a message that describes the problem.
 */
public class BadIsbn13Exception extends Exception{
    
    /**
     * @param message the detail message
     */
    public BadIsbn13Exception(String message) {
        super(message);
    }
}