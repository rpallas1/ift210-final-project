
import java.util.Scanner;

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
                    // DataManager.getInstance().updateEmployeeRole(employee, role);
                } else {
                    employeeDoesNotExist(id);
                }
            } catch (Exception e) {
                // If error is caught then that means that the user chose to exit the loop of
                // entering valid input
                doesEmployeeExist = true;
            }
        }

    }
}
