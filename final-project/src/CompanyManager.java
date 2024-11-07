
import java.util.ArrayList;

/**
 * Manages employee data within a Company Management System, allowing
 * for operations such as adding, removing, updating, and displaying
 * employee information. Contains the main menu logic and calls various
 * prompts and message displays.
 */
public class CompanyManager {
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();

    /**
     * Entry point of the application.
     * 
     * @param args command-line arguments (not-used)
     */
    public static void main(String[] args) {
        start();
    }

    /**
     * Starts the main program loop, displaying menu options and handling user
     * selection until the user chooses to exit.
     */
    public static void start() {
        int option = -1;

        Messages.menuHeader();

        while (option != 0) {
            option = Prompts.promptForMenuOption();

            switch (option) {
                case 0:
                    Messages.menuExited();
                    break;
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    updateRole();
                    break;
                case 4:
                    updateSalary();
                    break;
                case 5:
                    Messages.displayEmployeeList(employeeList);
                    break;
                case 6:
                    Messages.displaySalaryReport(employeeList);
                    break;
                default:
                    Messages.invalidMenuOption();
            }
        }
    }

    /**
     * Prompts the user to create a new employee and adds them to the employee list
     * if the creation is successful.
     */
    public static void addEmployee() {
        Employee employee = createEmployee();

        if (employee != null) {
            employeeList.add(employee);
            Messages.addEmployeeConfirmation();
        }
    }

    /**
     * Prompts the user to enter an employee ID, removes the corresponding employee
     * if they exist, and displays a confirmation message.
     */
    public static void removeEmployee() {
        String id = Prompts.removeEmployeePrompt();
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            employeeList.remove(employee);
            Messages.removeEmployeeConfirmation();
        }
    }

    /**
     * Prompts the user to enter an employee ID and updates the role of the
     * corresponding employee if they exist.
     */
    public static void updateRole() {
        String id = Prompts.promptForUpdateRoleId();
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            String role = Prompts.promptForUpdatedRole();
            employee.setRole(role);
        }
    }

    /**
     * Prompts the user to enter an employee ID and updates the salary of the
     * corresponding employee if they exist.
     */
    public static void updateSalary() {
        String id = Prompts.promptForUpdateSalaryId();
        Employee employee = getEmployeeById(id);

        if (employee != null) {
            double salary = Prompts.promptForUpdatedSalary();
            employee.setSalary(salary);
        }
    }

    /**
     * Creates and returns a new Employee object by prompting the user for unique
     * ID, name, salary, and role details.
     * 
     * @return a new Employee object, or null if the ID is not unique or the user
     *         decides to cancel
     */
    private static Employee createEmployee() {
        String id = askForUniqueId();

        if (id == null) {
            return null;
        }

        String name = Prompts.promptForName();
        String role = Prompts.promptForRole();
        double salary = Prompts.promptForSalary();

        return new Employee(id, name, salary, role);
    }

    /**
     * Searches and returns an employee with the specified ID.
     * 
     * @param id the ID of the employee to search for
     * @return the Employee with the specified ID, or null if no employee is found
     */
    private static Employee getEmployeeById(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeID().equals(id)) {
                return employeeList.get(i);
            }
        }

        Messages.employeeDoesNotExist(id);
        return null;
    }

    /**
     * Checks if an employee with the specified ID already exists.
     * 
     * @param id the ID to check for existence in the employee list
     * @return true if an employee with the ID exists, false otherwise
     */
    private static boolean doesEmployeeExist(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(id)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prompts the user to enter a unique employee ID and validates its uniqueness.
     * Allows the user to enter "0" to exit without providing an ID.
     * 
     * @return a unique employee ID, or null if the user decides to exit
     */
    private static String askForUniqueId() {
        String id = Prompts.promptForUniqueId();
        boolean doesIdExist = doesEmployeeExist(id);
        String exitString = "0";

        while (!id.equals(exitString) && doesIdExist) {
            Messages.addEmployeeError(id);
            id = Prompts.promptForUniqueId();
            doesIdExist = doesEmployeeExist(id);
        }

        if (id.equals(exitString)) {
            return null;
        }

        return id;
    }
}
