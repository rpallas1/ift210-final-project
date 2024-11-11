package tasks;

import java.util.Scanner;

import models.Employee;
import exceptions.MenuExitedException;
import managers.DataManager;

/**
 * Task for adding a new employee to the employee list. This class extends the
 * abstract Task class and provides functionality to prompt the user for
 * employee details and add the employee to the data manager.
 * 
 * @author Ryan Pallas
 *         created on 11/11/24
 */
public class AddEmployeeTask extends Task {
    /**
     * Constructs an AddEmployeeTask with the specified Scanner for user input.
     *
     * @param scanner the Scanner object used to read user input
     */
    public AddEmployeeTask(Scanner scanner) {
        super(scanner);
    }

    /**
     * Executes the add employee operation. This method prompts the user to
     * create a new employee by entering an ID, name, salary, and role. If
     * the employee is successfully created, it is added to the employee list.
     */
    @Override
    public void execute() {
        try {
            Employee employee = createEmployee();

            if (DataManager.getInstance().addEmployee(employee)) {
                divider();
                System.out.println("Employee added successfully");
                currentDateAndTime();
            } else {
                taskFailedMessage("Failed to add employee");
            }
        } catch (MenuExitedException mee) {
            menuExitedMessage(mee.getMessage());
        }
    }

    /**
     * Creates and returns a new Employee object by prompting the user for
     * a unique ID, name, salary, and role. If the
     * user decides to cancel, this method throws.
     * 
     * @return a new Employee object
     * @throws MenuExitedException if the user exits to the main menu
     */
    private Employee createEmployee() throws MenuExitedException {
        Employee employee = new Employee(
                askForUniqueId(),
                promptForName("Enter a name"),
                promptForRole("Enter a role"),
                promptForSalary("Enter a salary"));

        return employee;
    }

    /**
     * Prompts the user to enter a unique employee ID and validates its uniqueness.
     * Continues to prompt until a unique ID is entered or the user decides to exit.
     *
     * @return a unique employee ID
     * @throws MenuExitedException if the user exits to the main menu
     */
    private String askForUniqueId() throws MenuExitedException {
        String promptMessage = "Enter a unique id";
        String id = promptForId(promptMessage);
        boolean doesIdExist = doesEmployeeExist(id);

        while (doesIdExist) {
            divider();
            System.out.printf("ID must be unique: %s\n", id);
            divider();

            id = promptForId(promptMessage);
            doesIdExist = doesEmployeeExist(id);
        }

        return id;
    }

    /**
     * Checks if an employee with the specified ID already exists.
     * 
     * @param id the ID to check for existence in the employee list
     * @return true if an employee with the ID exists, false otherwise
     */
    private boolean doesEmployeeExist(String id) {
        return (DataManager.getInstance().doesEmployeeExist(id) != null);
    }
}
