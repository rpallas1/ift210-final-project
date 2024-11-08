/**
 * The UpdateRoleHandler class handles the operation of updating an employee's
 * role in the CompanyManager system. It extends CompanyManager and implements
 * the HandlerInterface to allow role updates based on user input.
 */
public class UpdateRoleHandler extends CompanyManager implements HandlerInterface {
    /**
     * Executes the update role operation. Prompts the user to enter an employee
     * ID, verifies if an employee with that ID exists, and updates their role
     * if found by prompting the user for a new role.
     */
    public void execute() {
        String id = promptForId();
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            String role = promptForRole();
            employee.setRole(role);
        }
    }

    /**
     * Prompts the user to enter an ID of the employee having its role updated.
     * 
     * @return a String representing the ID entered by the user
     */
    public String promptForId() {
        System.out.print("Enter ID of employee to update role: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter a role.
     * 
     * @return a String representing the role entered by the user
     */
    private String promptForRole() {
        System.out.print("Enter the updated role: ");

        // TODO: Validate input (can't be empty)
        return scanner.nextLine();
    }
}
