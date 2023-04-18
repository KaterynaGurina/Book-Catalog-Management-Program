// -----------------------------------------------------
// Assignment 3
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------

/**
 * This exception class is used to indicate that an invalid year has been encountered.
 */
public class BadYearException extends Exception {
    
    /**
     * @param message the detail message
     */
    public BadYearException(String message) {
        super(message);
    }
}