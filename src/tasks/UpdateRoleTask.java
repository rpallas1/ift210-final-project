package tasks;

import java.util.Scanner;

import models.Employee;
import exceptions.MenuExitedException;
import managers.DataManager;

/**
 * Class Name: IFT210
 * Author: Ryan Pallas
 * Date: 2024-11-11
 * 
 * Task for updating the role of an employee in the employee list. This class
 * extends the abstract Task class and provides functionality to prompt the
 * user for an employee ID and update the employee's role if found.
 */
public class UpdateRoleTask extends Task {
    /**
     * Constructs an UpdateRoleTask with the specified Scanner for user input.
     *
     * @param scanner the Scanner object used to read user input
     */
    public UpdateRoleTask(Scanner scanner) {
        super(scanner);
    }

    /**
     * Executes the update role operation. Prompts the user to enter an employee
     * ID, verifies if an employee with that ID exists, and updates their role
     * if found by prompting the user for a new role.
     */
    @Override
    public void execute() {
        boolean doesEmployeeExist = false;

        while (!doesEmployeeExist) {
            try {
                String id = promptForId("Enter ID of employee to update role");
                Employee employee = DataManager.getInstance().doesEmployeeExist(id);

                if (employee != null) {
                    doesEmployeeExist = true;
                    String role = promptForRole("Enter the updated role");
                    employee.setRole(role);

                    if (DataManager.getInstance().updateEmployee(employee) != null) {
                        divider();
                        System.out.println("Employee role updated successfully");
                        currentDateAndTime();
                    } else {
                        taskFailedMessage("Failed to update role");
                    }
                } else {
                    employeeDoesNotExistMessage(id);
                }
            } catch (MenuExitedException mee) {
                menuExitedMessage(mee.getMessage());

                break;
            }
        }
    }
}
