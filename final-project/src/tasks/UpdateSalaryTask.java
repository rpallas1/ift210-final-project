package tasks;

import java.util.Scanner;

import exceptions.MenuExitedException;
import managers.DataManager;
import models.Employee;

public class UpdateSalaryTask extends Task {
    public UpdateSalaryTask(Scanner scanner) {
        super(scanner);
    }

    /**
     * Executes the update salary operation. Prompts the user to enter an employee
     * ID, verifies if an employee with that ID exists, and updates their salary
     * if found by prompting the user for a new salary.
     */
    @Override
    public void execute() {
        boolean doesEmployeeExist = false;

        while (!doesEmployeeExist) {
            try {
                String id = promptForId("Enter ID of employee to update salary");
                Employee employee = DataManager.getInstance().doesEmployeeExist(id);

                if (employee != null) {
                    doesEmployeeExist = true;
                    double salary = promptForSalary("Enter the updated salary");
                    employee.setSalary(salary);

                    if (DataManager.getInstance().updateEmployee(employee) != null) {
                        divider();
                        System.out.println("Employee salary updated successfully");
                        currentDateAndTime();
                    } else {
                        taskFailedMessage("Failed to update salary");
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
