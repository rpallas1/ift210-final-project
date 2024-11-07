import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Utility class that provides methods to display various messages for the
 * Company Management System, including menu options, confirmations, error
 * messages, and formatted tables of employee data.
 */
public class Messages {
    /**
     * Displays the main menu options for the user.
     */
    public static void displayMenu() {
        System.out.println("0 - Exit");
        System.out.println("1 - Add Employee");
        System.out.println("2 - Remove Employee");
        System.out.println("3 - Update Employee Role");
        System.out.println("4 - Update Employee Salary");
        System.out.println("5 - Display Employee List");
        System.out.println("6 - Display Salary Report");
        System.out.print("Enter option (0 to 6): ");
    }

    /**
     * Displays a message indicating an invalid menu option was selected.
     */
    public static void invalidMenuOption() {
        System.out.println("\nInvalid option, try again please.\n");
    }

    /**
     * Displays the menu header with author information and system title.
     */
    public static void menuHeader() {
        System.out.println("Ryan Pallas - 1226061293");
        divider();
        System.out.println("Company Management System");
        divider();
    }

    /**
     * Displays a message indicating that the menu has been exited.
     */
    public static void menuExited() {
        divider();
        System.out.println("Company Manager Exited");
        divider();
    }

    /**
     * Displays a confirmation message when an employee has been added successfully.
     */
    public static void addEmployeeConfirmation() {
        divider();
        System.out.println("Employee added successfully");
        currentDateAndTime();
    }

    /**
     * Displays an error message if an employee with a specified ID already exists.
     * 
     * @param id the employee ID that must be unique
     */
    public static void addEmployeeError(String id) {
        divider();
        System.out.printf("ID must be unique: %s\n", id);
        divider();
    }

    /**
     * Displays a confirmation message when an employee has been removed
     * successfully.
     */
    public static void removeEmployeeConfirmation() {
        divider();
        System.out.println("Employee removed successfully");
        currentDateAndTime();
    }

    /**
     * Displays a message indicating that no employee exists for the specified ID.
     * 
     * @param id the employee ID that was not found
     */
    public static void employeeDoesNotExist(String id) {
        divider();
        System.out.printf("No employee exists for ID: %s\n", id);
        divider();
    }

    /**
     * Displays a formatted list of all employees in the system.
     * 
     * @param employeeList the list of employees to display
     */
    public static void displayEmployeeList(ArrayList<Employee> employeeList) {
        dashDivider();
        System.out.printf("%-25sEmployee List\n", " ");
        dashDivider();

        employeeTable(employeeList);
    }

    /**
     * Displays a salary report with the total salary of all employees.
     * 
     * @param employeeList the list of employees to include in the salary report
     */
    public static void displaySalaryReport(ArrayList<Employee> employeeList) {
        double totalSalary = 0;

        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }

        // TODO: Sort employees by salary and pass it into employeeTable()

        dashDivider();
        System.out.printf("%-25sSalary Report\n", " ");
        dashDivider();

        employeeTable(employeeList);

        System.out.printf("Total Salary: %.1f\n", totalSalary);
    }

    /**
     * Displays a divider made of "=" characters.
     */
    public static void divider() {
        System.out.println("=".repeat(35));
    }

    /**
     * Displays a table of employee information with ID, name, role, and salary.
     * 
     * @param employeeList the list of employees to display in the table
     */
    private static void employeeTable(ArrayList<Employee> employeeList) {
        tableRow("ID", "Name", "Role", "Salary");
        dashDivider();

        if (employeeList.size() == 0) {
            System.out.printf("|%-22sNo employees in list%-19s|\n", " ", " ");
        } else {
            for (Employee employee : employeeList) {
                tableRow(employee.getEmployeeID(),
                        employee.getEmployeeName(),
                        employee.getRole(),
                        employee.getSalary());
            }
        }

        dashDivider();
    }

    /**
     * Displays a divider made of "-" characters.
     */
    private static void dashDivider() {
        System.out.println("-".repeat(65));
    }

    /**
     * Formats and displays a row in the employee table with ID, name, role, and
     * salary.
     * 
     * @param id     the employee ID
     * @param name   the employee's name
     * @param role   the employee's role
     * @param salary the employee's salary
     */
    private static void tableRow(String id, String name, String role, double salary) {
        System.out.printf("| %-10s | %-15s | %-15s | %-12.2f |\n", id, name, role, salary);
    }

    /**
     * Formats and displays the header row in the employee table with ID, Name,
     * Role, and Salary as a String.
     * 
     * @param id     column header for id's
     * @param name   column header for name's
     * @param role   column header for role's
     * @param salary column header for salaries
     */
    private static void tableRow(String id, String name, String role, String salary) {
        System.out.printf("| %-10s | %-15s | %-15s | %-12s |\n", id, name, role, salary);
    }

    /**
     * Displays the current date and time in a formatted string with dividers.
     */
    private static void currentDateAndTime() {
        divider();
        System.out.printf("Current time: %s\n", getDateAndTime());
        divider();
    }

    /**
     * Displays the current date in a formatted string with dividers.
     */
    private static void currentDate() {
        divider();
        System.out.printf("Current date: %s\n", getDate());
        divider();
    }

    /**
     * Returns the current date as a formatted string.
     * 
     * @return a String representing the current date and time in the format
     *         "MM/dd/yyyy"
     */
    private static String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = dateFormat.format(date);
        return currentDate;
    }

    /**
     * Returns the current date and time as a formatted string.
     * 
     * @return a String representing the current date and time in the format
     *         "MM/dd/yyyy HH:mm:ss"
     */
    private static String getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String currentDate = dateFormat.format(date);
        return currentDate;
    }
}
