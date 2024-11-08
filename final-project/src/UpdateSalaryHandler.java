/**
 * The UpdateSalaryHandler class manages the operation of updating an employee's
 * salary in the CompanyManager system. It extends CompanyManager and implements
 * the HandlerInterface to provide functionality for salary updates based on
 * user input.
 */
public class UpdateSalaryHandler extends CompanyManager implements HandlerInterface {
    /**
     * Executes the update salary operation. Prompts the user to enter an employee
     * ID, verifies if an employee with that ID exists, and updates their salary
     * if found by prompting the user for a new salary.
     */
    public void execute() {
        String id = promptForId();
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            double salary = promptForSalary();
            employee.setSalary(salary);
        }
    }

    /**
     * Prompts the user to enter an ID of the employee having its salary updated.
     * 
     * @return a String representing the ID entered by the user
     */
    public String promptForId() {
        System.out.print("Enter ID of employee to update salary: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter an updated salary.
     * 
     * @return a double representing the salary entered by the user
     */
    private double promptForSalary() {
        System.out.print("Enter the updated salary: ");

        // TODO: Validate salary
        double salary = scanner.nextDouble();
        scanner.nextLine();

        return salary;
    }
}
