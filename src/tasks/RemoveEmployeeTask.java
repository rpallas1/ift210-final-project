package tasks;

import java.util.Scanner;

import models.Employee;
import exceptions.MenuExitedException;
import managers.DataManager;

/**
 * Class Name: IFT210
 * Authors: Ryan Pallas and Nikhit Gunturu
 * Date: 2024-11-11
 * 
 * Task for removing an employee from the employee list. This class extends the
 * abstract Task class and provides functionality to prompt the user for an
 * employee ID and remove the corresponding employee if found.
 */
public class RemoveEmployeeTask extends Task {
    /**
     * Constructs a RemoveEmployeeTask with the specified Scanner for user input.
     *
     * @param scanner the Scanner object used to read user input
     */
    public RemoveEmployeeTask(Scanner scanner) {
        super(scanner);
    }

    /**
     * Executes the remove employee operation. Prompts the user to enter an
     * employee ID, verifies if an employee with that ID exists, and removes
     * them from the employee list if found. Displays a confirmation message
     * upon successful removal.
     */
    @Override
    public void execute() {
        boolean doesEmployeeExist = false;

        while (!doesEmployeeExist) {
            try {
                String id = promptForId("Enter ID of employee to remove: ");
                Employee employee = DataManager.getInstance().doesEmployeeExist(id);

                if (employee != null) {
                    doesEmployeeExist = true;

                    if (DataManager.getInstance().removeEmployee(employee)) {
                        divider();
                        System.out.println("Employee removed successfully");
                        currentDateAndTime();
                    } else {
                        taskFailedMessage("Failed to remove employee");
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
