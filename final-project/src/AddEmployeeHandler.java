/**
 * The AddEmployeeHandler class is responsible for handling the process of
 * creating and adding new employees to the employee list within the
 * CompanyManager system. This class extends CompanyManager and implements
 * HandlerInterface to facilitate the employee addition operation.
 */
class AddEmployeeHandler extends CompanyManager implements HandlerInterface {
    /**
     * Executes the add employee operation. This method prompts the user to
     * create a new employee by entering an ID, name, salary, and role. If
     * the creation is successful, the employee is added to the employee list.
     */
    public void execute() {
        Employee employee = createEmployee();

        if (employee != null) {
            employeeList.add(employee);

            divider();
            System.out.println("Employee added successfully");
            currentDateAndTime();
        }
    }

    /**
     * Creates and returns a new Employee object by prompting the user for
     * a unique ID, name, salary, and role. If the ID is not unique or if the
     * user decides to cancel, this method returns null.
     * 
     * @return a new Employee object, or null if the user cancels or ID is not
     *         unique
     */
    private Employee createEmployee() {
        String id = askForUniqueId();

        if (id == null) {
            return null;
        }

        String name = promptForName();
        String role = promptForRole();
        double salary = promptForSalary();

        return new Employee(id, name, salary, role);
    }

    /**
     * Prompts the user to enter a unique employee ID and validates its uniqueness.
     * Allows the user to enter "0" to exit without providing an ID.
     * 
     * @return a unique employee ID, or null if the user decides to exit
     */
    private String askForUniqueId() {
        String id = promptForId();
        boolean doesIdExist = doesEmployeeExist(id);
        String exitString = "0";

        while (!id.equals(exitString) && doesIdExist) {
            divider();
            System.out.printf("ID must be unique: %s\n", id);
            divider();

            id = promptForId();
            doesIdExist = doesEmployeeExist(id);
        }

        if (id.equals(exitString)) {
            return null;
        }

        return id;
    }

    /**
     * Prompts the user to enter an ID, with the option to return to the menu by
     * entering 0.
     * 
     * @return a String representing the ID entered by the user
     */
    public String promptForId() {
        System.out.print("Enter a unique id (Enter 0 to return to menu): ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter a name.
     * 
     * @return a String representing the name entered by the user
     */
    private String promptForName() {
        System.out.print("Enter a name: ");

        // TODO: Validate name
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a salary.
     * 
     * @return a double representing the salary entered by the user
     */
    private double promptForSalary() {
        System.out.print("Enter a salary: ");

        // TODO: Validate salary
        double salary = scanner.nextDouble();
        scanner.nextLine();

        return salary;
    }

    /**
     * Prompts the user to enter a role.
     * 
     * @return a String representing the role entered by the user
     */
    private String promptForRole() {
        System.out.print("Enter a role: ");

        // TODO: Validate input (can't be empty)
        return scanner.nextLine();
    }

    /**
     * Checks if an employee with the specified ID already exists.
     * 
     * @param id the ID to check for existence in the employee list
     * @return true if an employee with the ID exists, false otherwise
     */
    private boolean doesEmployeeExist(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
