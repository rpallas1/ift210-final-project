
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Manages employee data within a Company Management System, allowing
 * for operations such as adding, removing, updating, and displaying
 * employee information. Contains the main menu logic and calls various
 * prompts and message displays.
 */
public class CompanyManager {
    protected static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    protected static Scanner scanner = new Scanner(System.in);

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
        HandlerInterface currentTask = null;

        menuHeader();

        while (option != 0) {
            currentTask = null;
            option = promptForMenuOption();

            switch (option) {
                case 0:
                    menuExited();
                    break;
                case 1:
                    currentTask = new AddEmployeeHandler();
                    break;
                case 2:
                    currentTask = new RemoveEmployeeHandler();
                    break;
                case 3:
                    currentTask = new UpdateRoleHandler();
                    break;
                case 4:
                    currentTask = new UpdateSalaryHandler();
                    break;
                case 5:
                    displayEmployeeList();
                    break;
                case 6:
                    displaySalaryReport();
                    break;
                default:
                    invalidInput();
            }

            if (currentTask != null) {
                currentTask.execute();
            }
        }

        scanner.close();
    }

    /**
     * Searches and returns an employee with the specified ID.
     * 
     * @param id the ID of the employee to search for
     * @return the Employee with the specified ID, or null if no employee is found
     */
    protected Employee getEmployeeById(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeID().equals(id)) {
                return employeeList.get(i);
            }
        }

        employeeDoesNotExist(id);
        return null;
    }

    /**
     * Displays a message indicating that no employee exists for the specified ID.
     * 
     * @param id the employee ID that was not found
     */
    private static void employeeDoesNotExist(String id) {
        divider();
        System.out.printf("No employee exists for ID: %s\n", id);
        divider();
    }

    /**
     * Displays the menu header with author information and system title.
     */
    private static void menuHeader() {
        divider();
        System.out.println("Ryan Pallas - 1226061293");
        divider();
        System.out.println("Company Management System");
        divider();
    }

    /**
     * Prompts the user to select a menu option by displaying available options.
     * 
     * @return the integer selected by the user representing the chosen menu option
     */
    private static int promptForMenuOption() {
        displayMenu();

        // TODO: Validate input (should only be an int)
        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    /**
     * Displays the main menu options for the user.
     */
    private static void displayMenu() {
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
     * Displays a message indicating that the menu has been exited.
     */
    private static void menuExited() {
        divider();
        System.out.println("Company Manager Exited");
        divider();
    }

    /**
     * Displays a message indicating that an invalid menu option was chosen.
     */
    private static void invalidInput() {
        divider();
        System.out.println("Invalid option, please enter a number 0 to 6.");
        divider();
    }

    /**
     * Displays a formatted list of all employees in the system.
     */
    private static void displayEmployeeList() {
        dashDivider();
        System.out.printf("%-25sEmployee List\n", " ");
        dashDivider();

        employeeTable();
    }

    /**
     * Displays a salary report with the total salary of all employees.
     */
    private static void displaySalaryReport() {
        double totalSalary = 0;

        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }

        // TODO: Sort employees by salary and pass it into employeeTable()

        dashDivider();
        System.out.printf("%-25sSalary Report\n", " ");
        dashDivider();

        employeeTable();

        System.out.printf("Total Salary: %.1f\n", totalSalary);
    }

    /**
     * Displays a table of employee information with ID, name, role, and salary.
     */
    private static void employeeTable() {
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
     * Displays a divider made of "-" characters.
     */
    private static void dashDivider() {
        System.out.println("-".repeat(65));
    }

    /**
     * Displays a divider made of "=" characters.
     */
    public static void divider() {
        System.out.println("=".repeat(35));
    }

    /**
     * Displays the current date and time in a formatted string with dividers.
     */
    protected static void currentDateAndTime() {
        divider();
        System.out.printf("Current time: %s\n", getDateAndTime());
        divider();
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
