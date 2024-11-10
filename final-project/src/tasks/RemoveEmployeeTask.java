package tasks;

import java.util.Scanner;

import models.Employee;
import exceptions.MenuExitedException;
import managers.DataManager;

public class RemoveEmployeeTask extends Task {
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
