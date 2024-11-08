/**
 * The RemoveEmployeeHandler class manages the removal of employees from the
 * CompanyManager system. This class extends CompanyManager and implements
 * HandlerInterface to perform employee removal operations.
 */
public class RemoveEmployeeHandler extends CompanyManager implements HandlerInterface {
    /**
     * Executes the remove employee operation. Prompts the user to enter an
     * employee ID, verifies if an employee with that ID exists, and removes
     * them from the employee list if found. Displays a confirmation message
     * upon successful removal.
     */
    public void execute() {
        String id = promptForId();
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            employeeList.remove(employee);

            divider();
            System.out.println("Employee removed successfully");
            currentDateAndTime();
        }
    }

    /**
     * Prompts the user to enter the ID of an employee to remove.
     * 
     * @return a String representing the employee ID entered by the user
     */
    public String promptForId() {
        divider();
        System.out.print("Enter ID of employee to remove: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }
}
