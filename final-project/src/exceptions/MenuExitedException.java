package exceptions;

public class MenuExitedException extends Exception {
    public MenuExitedException() {
        super("Exiting to menu");
    }

    public MenuExitedException(String message) {
        super(message);
    }
}
