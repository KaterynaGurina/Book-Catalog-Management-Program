// -----------------------------------------------------
// Assignment 3
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------

/**
 * This exception class is used to indicate that a required field is missing.
 * This exception is thrown when a required field is missing, and includes a message that describes the problem.
 */
public class MissingFieldException extends Exception {    
    /**
     * Constructs a new {@code MissingFieldException} with the specified detail message.
     *
     * @param message the detail message
     */
    public MissingFieldException(String message) {
        super(message);
    }
}