// -----------------------------------------------------
// Assignment 3
// Written by: Kateryna Gurina_40188793
// -----------------------------------------------------

/**
 * This exception class is used to indicate that an invalid price has been encountered.
 */
public class BadPriceException extends Exception {
    
    /**
     * @param message the detail message
     */
    public BadPriceException(String message) {
        super(message);
    }
}