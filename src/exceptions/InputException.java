package exceptions;

/**
 * Class Name: IFT210
 * Authors: Ryan Pallas and Nikhit Gunturu
 * Date: 2024-11-11
 * 
 * Custom exception class that is thrown when there is an issue with user input.
 * <p>
 * This exception extends the {@link Exception} class and is used to signal
 * invalid or
 * problematic input within the application. It allows for custom error messages
 * to provide
 * additional details about the nature of the input issue.
 * </p>
 */
public class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}
