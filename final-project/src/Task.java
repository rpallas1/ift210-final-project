import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Task implements Executor {
    private Scanner scanner;

    public Task(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Prompts the user to enter a valid ID for a Employee and will continue to
     * prompt them until a valid ID is entered or they exit to the main menu.
     * 
     * @param message
     * @return
     * @throws Exception
     */
    protected String promptForId(String message) throws Exception {
        String id = "";
        InputValidator validator = new InputValidator();
        boolean isValid = false;
        String exitString = "0";

        message = prepMessage(message);

        while (!id.equals(exitString) && !isValid) {
            try {
                System.out.print(message);
                id = scanner.nextLine();
                id = validator.validateId(id);
                isValid = true;
            } catch (Exception e) {
                // Non-valid ID entered, repeat while-loop
                System.out.println(">>> Please enter a valid ID");
            }
        }

        // User wants to exit to main menu
        if (id.equals(exitString)) {
            throw new Exception();
        }

        return id;
    }

    /**
     * Prompts the user for a valid name and will continue to prompt them until a
     * valid name is entered or they exit to the main menu.
     * 
     * @param message
     * @return
     * @throws Exception
     */
    protected String promptForName(String message) throws Exception {
        String name = "";
        InputValidator validator = new InputValidator();
        boolean isValid = false;
        String exitString = "0";

        message = prepMessage(message);

        while (!name.equals(exitString) && !isValid) {
            try {
                System.out.print(message);
                name = scanner.nextLine();
                name = validator.validateName(name);
                isValid = true;
            } catch (Exception e) {
                // Non-valid ID entered, repeat while-loop
                System.out.println(">>> Please enter a valid name");
            }
        }

        // User wants to exit to main menu
        if (name.equals(exitString)) {
            throw new Exception();
        }

        return name;
    }

    /**
     * Prompts the user for a valid role and will continue to prompt them until a
     * valid role is entered or they exit to the main menu.
     * 
     * @param message
     * @return
     * @throws Exception
     */
    protected String promptForRole(String message) throws Exception {
        String role = "";
        InputValidator validator = new InputValidator();
        boolean isValid = false;
        String exitString = "0";

        message = prepMessage(message);

        while (!role.equals(exitString) && !isValid) {
            try {
                System.out.print(message);
                role = scanner.nextLine();
                role = validator.validateRole(role);
                isValid = true;
            } catch (Exception e) {
                // Non-valid ID entered, repeat while-loop
                System.out.println(">>> Please enter a valid role");
            }
        }

        // User wants to exit to main menu
        if (role.equals(exitString)) {
            throw new Exception();
        }

        return role;
    }

    /**
     * Prompts the user for a valid salary and will continue to prompt them until a
     * valid salary is entered or they exit to the main menu.
     * 
     * @param message
     * @return
     * @throws Exception
     */
    protected Double promptForSalary(String message) throws Exception {
        String salary = "";
        double validatedSalary = -1;
        InputValidator validator = new InputValidator();
        boolean isValid = false;
        String exitString = "0";

        message = prepMessage(message);

        while (!salary.equals(exitString) && !isValid) {
            try {
                System.out.print(message);
                salary = scanner.nextLine();
                validatedSalary = validator.validateSalary(salary);
                isValid = true;
            } catch (Exception e) {
                // Non-valid ID entered, repeat while-loop
                System.out.println(">>> Please enter a valid salary");
            }
        }

        // User wants to exit to main menu
        if (salary.equals(exitString)) {
            throw new Exception();
        }

        return validatedSalary;
    }

    /**
     * Displays a message indicating that no employee exists for the specified ID.
     * 
     * @param id the employee ID that was not found
     */
    protected void employeeDoesNotExist(String id) {
        divider();
        System.out.printf("No employee exists for ID: %s\n", id);
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
     * 
     * @return a String representing the current date and time in the format
     *         "MM/dd/yyyy HH:mm:ss"
     */
    private String getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String currentDate = dateFormat.format(date);
        return currentDate;
    }

    private String prepMessage(String message) {
        return message.trim() + " (Enter 0 to return to menu): ";
    }
}
