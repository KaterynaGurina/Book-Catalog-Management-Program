// -----------------------------------------------------
// Assignment 3
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------

/**
 * This exception class is used to indicate that an invalid ISBN length has been encountered.
 * This exception is thrown when the length of the ISBN is not valid for the ISBN type (e.g. ISBN-10 or ISBN-13),
 * and includes a message that describes the problem.
 */
public class BadIsbnLengthException extends Exception{
    
    /**
     * @param message the detail message 
     */
    public BadIsbnLengthException (String message) {
        super(message);
    }

}




