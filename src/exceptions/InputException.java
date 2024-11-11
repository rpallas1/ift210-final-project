package exceptions;

/**
 * Custom exception class that is thrown when there is an issue with user input.
 * <p>
 * This exception extends the {@link Exception} class and is used to signal
 * invalid or
 * problematic input within the application. It allows for custom error messages
 * to provide
 * additional details about the nature of the input issue.
 * </p>
 * 
 * @author Ryan Pallas
 *         created on 11/11/24
 */
public class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}
