package exceptions;

/**
 * Custom exception class that is thrown when the user exits a menu.
 * <p>
 * This exception extends the {@link Exception} class and is used to signal that
 * the user has exited a menu or navigated away from it. It can be used to
 * handle
 * menu exit events and provide meaningful messages regarding the exit status.
 * </p>
 * 
 * @author Ryan Pallas
 *         created on 11/11/24
 */
public class MenuExitedException extends Exception {
    /**
     * Constructs a new MenuExitedException with the default detail message.
     * <p>
     * The default message "Exiting to menu" is passed to the parent
     * {@link Exception}
     * class, indicating that the user is exiting the menu.
     * </p>
     */
    public MenuExitedException() {
        super("Exiting to menu");
    }

    /**
     * Constructs a new MenuExitedException with the specified detail
     * message.
     * <p>
     * This constructor allows for a custom message to be provided, which can be
     * used
     * to convey more specific information about the menu exit event.
     * </p>
     *
     * @param message the detail message, which provides additional information
     *                about the exit event.
     */
    public MenuExitedException(String message) {
        super(message);
    }
}
