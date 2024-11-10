package tasks;

import java.util.Scanner;

import models.Employee;
import exceptions.MenuExitedException;
import managers.DataManager;

public class UpdateRoleTask extends Task {
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
