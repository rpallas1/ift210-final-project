package tasks;

import java.util.Scanner;

import exceptions.MenuExitedException;
import managers.DataManager;
import models.Employee;

/**
 * Class Name: IFT210
 * Authors: Ryan Pallas and Nikhit Gunturu
 * Date: 2024-11-11
 * 
 * Task for updating the salary of an employee in the employee list. This class
 * extends the abstract Task class and provides functionality to prompt the
 * user for an employee ID and update the employee's salary if found.
 */
public class UpdateSalaryTask extends Task {
    /**
     * Constructs an UpdateSalaryTask with the specified Scanner for user input.
     *
     * @param scanner the Scanner object used to read user input
     */
    public UpdateSalaryTask(Scanner scanner) {
        super(scanner);
    }

    /**
     * Executes the update salary operation. Prompts the user to enter an employee
     * ID, verifies if an employee with that ID exists, and updates their salary
     * if found by prompting the user for a new salary amount.
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
