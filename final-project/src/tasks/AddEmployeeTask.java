package tasks;

import java.util.Scanner;

import models.Employee;
import exceptions.MenuExitedException;
import managers.DataManager;

public class AddEmployeeTask extends Task {
    public AddEmployeeTask(Scanner scanner) {
        super(scanner);
    }

    /**
     * Executes the add employee operation. This method prompts the user to
     * create a new employee by entering an ID, name, salary, and role. If
     * the creation is successful, the employee is added to the employee list.
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
     * a unique ID, name, salary, and role. If the ID is not unique or if the
     * user decides to cancel, this method returns null.
     * 
     * @return a new Employee object, or null if the user cancels or ID is not
     *         unique
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
     * Allows the user to enter "0" to exit without providing an ID.
     * 
     * @return a unique employee ID, or null if the user decides to exit
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
