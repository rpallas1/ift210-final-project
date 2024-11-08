/**
 * The HandlerInterface provides a contract for handling specific actions
 * within an application, including executing defined operations and
 * prompting for an ID input.
 */
public interface HandlerInterface {

    /**
     * Executes the primary operation defined by the implementing class.
     * This method performs a specific action when invoked.
     */
    public void execute();

    /**
     * Prompts for and retrieves an ID as a string input.
     * Implementations should define the method for obtaining the ID.
     *
     * @return a String representing the requested ID
     */
    public String promptForId();
}
