package tasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptions.InputException;
import exceptions.MenuExitedException;
import helpers.InputValidator;

/**
 * Class Name: IFT210
 * Authors: Ryan Pallas and Nikhit Gunturu
 * Date: 2024-11-11
 * 
 * An abstract base class representing a task in the Company Management System.
 * Provides common methods for prompting user input, validating input, and
 * displaying messages. Subclasses must implement the abstract execute method to
 * define specific task behavior.
 * <p>
 * This class is designed to handle input prompts, validation, and common
 * messaging
 * functionalities such as displaying success/failure messages,
 * employee-not-found
 * alerts, and system time output.
 * </p>
 */
public abstract class Task {
    private Scanner scanner;

    /**
     * Constructs a Task with the specified Scanner for user input.
     * <p>
     * The provided Scanner is used to read user input for the task.
     * </p>
     * 
     * @param scanner the Scanner object used to read user input
     */
    public Task(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Executes the specific task action. Must be implemented by subclasses.
     * <p>
     * This method should define the behavior of the task, which will vary based
     * on the specific task subclass.
     * </p>
     */
    public abstract void execute();

    /**
     * Prompts the user to enter a valid employee ID and validates it,
     * continuing to prompt until a valid ID is entered or the user opts to exit
     * to the main menu.
     * <p>
     * The method uses the {@link InputValidator} to ensure the ID is valid
     * (non-empty and no whitespace).
     * </p>
     * 
     * @param message the prompt message displayed to the user
     * @return a validated employee ID
     * @throws MenuExitedException if the user exits to the main menu by entering
     *                             "q"
     */
    protected String promptForId(String message) throws MenuExitedException {
        String id = "";
        InputValidator validator = new InputValidator();
        boolean isValid = false;

        message = prepMessage(message);

        while (!isValid) {
            try {
                System.out.print(message);
                id = validator.validateId(scanner.nextLine());
                isValid = true;
            } catch (InputException ie) {
                System.out.printf(">>> Invalid ID - %s\n", ie.getMessage());
            }
        }

        return id;
    }

    /**
     * Prompts the user to enter a valid employee name and validates it,
     * continuing to prompt until a valid name is entered or the user exits.
     * <p>
     * The method uses the {@link InputValidator} to ensure the name is valid
     * (non-empty and contains no numbers).
     * </p>
     * 
     * @param message the prompt message displayed to the user
     * @return a validated employee name
     * @throws MenuExitedException if the user exits to the main menu by entering
     *                             "q"
     */
    protected String promptForName(String message) throws MenuExitedException {
        String name = "";
        InputValidator validator = new InputValidator();
        boolean isValid = false;

        message = prepMessage(message);

        while (!isValid) {
            try {
                System.out.print(message);
                name = validator.validateName(scanner.nextLine());
                isValid = true;
            } catch (InputException ie) {
                System.out.printf(">>> Invalid name - %s\n", ie.getMessage());
            }
        }

        return name;
    }

    /**
     * Prompts the user to enter a valid role and validates it,
     * continuing to prompt until a valid role is entered or the user exits.
     * <p>
     * The method uses the {@link InputValidator} to ensure the role is valid
     * (non-empty).
     * </p>
     * 
     * @param message the prompt message displayed to the user
     * @return a validated employee role
     * @throws MenuExitedException if the user exits to the main menu by entering
     *                             "q"
     */
    protected String promptForRole(String message) throws MenuExitedException {
        String role = "";
        InputValidator validator = new InputValidator();
        boolean isValid = false;

        message = prepMessage(message);

        while (!isValid) {
            try {
                System.out.print(message);
                role = validator.validateRole(scanner.nextLine());
                isValid = true;
            } catch (InputException ie) {
                System.out.printf(">>> Invalid role - %s\n", ie.getMessage());
            }
        }

        return role;
    }

    /**
     * Prompts the user to enter a valid salary and validates it,
     * continuing to prompt until a valid salary is entered or the user exits.
     * <p>
     * The method uses the {@link InputValidator} to ensure the salary is valid
     * (a non-negative number).
     * </p>
     * 
     * @param message the prompt message displayed to the user
     * @return a validated salary as a Double
     * @throws MenuExitedException if the user exits to the main menu by entering
     *                             "q"
     */
    protected Double promptForSalary(String message) throws MenuExitedException {
        double salary = -1;
        InputValidator validator = new InputValidator();
        boolean isValid = false;

        message = prepMessage(message);

        while (!isValid) {
            try {
                System.out.print(message);
                salary = validator.validateSalary(scanner.nextLine());
                isValid = true;
            } catch (InputException ie) {
                System.out.printf(">>> Invalid salary - %s\n", ie.getMessage());
            }
        }

        return salary;
    }

    /**
     * Displays a message indicating that no employee exists for the specified ID.
     * 
     * @param id the employee ID that was not found
     */
    protected void employeeDoesNotExistMessage(String id) {
        divider();
        System.out.printf("No employee exists for ID: %s\n", id);
        divider();
    }

    /**
     * Displays a formatted exit message.
     *
     * @param message the message to be displayed upon exit
     */
    protected void menuExitedMessage(String message) {
        divider();
        System.out.println(message);
        divider();
    }

    /**
     * Displays a failure message for a task.
     *
     * @param message the message to be displayed upon task failure
     */
    protected void taskFailedMessage(String message) {
        divider();
        System.out.println(message);
        divider();
    }

    /**
     * Displays a divider made of "=" characters.
     */
    protected void divider() {
        System.out.println("=".repeat(35));
    }

    /**
     * Displays the current date and time in a formatted string with dividers.
     */
    protected void currentDateAndTime() {
        divider();
        System.out.printf("Current time: %s\n", getDateAndTime());
        divider();
    }

    /**
     * Returns the current date and time as a formatted string.
     * <p>
     * The date and time is formatted in the "MM/dd/yyyy HH:mm:ss" format.
     * </p>
     * 
     * @return a String representing the current date and time
     */
    private String getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String currentDate = dateFormat.format(date);
        return currentDate;
    }

    /**
     * Prepares the prompt message by trimming whitespace and appending
     * instructions to return to the main menu.
     *
     * @param message the original message
     * @return the modified message with additional instructions
     */
    private String prepMessage(String message) {
        return message.trim() + " (Enter q to return to menu): ";
    }
}
