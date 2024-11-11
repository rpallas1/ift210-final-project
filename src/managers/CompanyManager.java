package managers;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import tasks.*;
import models.Employee;

/**
 * Manages employee data within a Company Management System, allowing
 * for operations such as adding, removing, updating, and displaying
 * employee information. Contains the main menu logic and calls various
 * prompts and message displays.
 * 
 * @author Ryan Pallas
 *         created on 11/11/24
 */
public class CompanyManager {
    /**
     * Entry point of the application.
     * 
     * @param args command-line arguments (not-used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        start(scanner);

        scanner.close();
    }

    /**
     * Starts the main program loop, displaying menu options and handling user
     * selection until the user chooses to exit.
     *
     * @param scanner the Scanner object for reading user input.
     */
    public static void start(Scanner scanner) {
        String option = "";
        Task currentTask = null;

        menuHeader();

        while (!option.equals("0")) {
            currentTask = null;
            option = promptForMenuOption(scanner);

            switch (option) {
                case "0":
                    menuExited();
                    break;
                case "1":
                    currentTask = new AddEmployeeTask(scanner);
                    break;
                case "2":
                    currentTask = new RemoveEmployeeTask(scanner);
                    break;
                case "3":
                    currentTask = new UpdateRoleTask(scanner);
                    break;
                case "4":
                    currentTask = new UpdateSalaryTask(scanner);
                    break;
                case "5":
                    displayEmployeeList();
                    break;
                case "6":
                    displaySalaryReport();
                    break;
                default:
                    invalidInput();
            }

            if (Objects.nonNull(currentTask)) {
                currentTask.execute();
            }
        }
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
     * @param scanner the Scanner object for reading user input.
     * @return the selected menu option as a lowercase String.
     */
    private static String promptForMenuOption(Scanner scanner) {
        displayMenu();

        String option = scanner.next().toLowerCase().trim();
        scanner.nextLine();

        System.out.println();

        return option;
    }

    /**
     * Displays the main menu options for the user, listing available
     * actions within the application.
     */
    private static void displayMenu() {
        System.out.println("\n0 - Exit");
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

        employeeTable(DataManager.getInstance().getEmployees());
    }

    /**
     * Displays a salary report with the total salary of all employees.
     */
    private static void displaySalaryReport() {
        DataManager dataManager = DataManager.getInstance();

        dashDivider();
        System.out.printf("%-25sSalary Report\n", " ");
        dashDivider();

        employeeTable(dataManager.getEmployeesSortedBySalary());

        System.out.printf("Total Salary: %.1f\n", dataManager.getTotalSalary());
    }

    /**
     * Displays a table of employee information including ID, name, role, and
     * salary.
     *
     * @param employeeList an ArrayList of Employee objects to display in the table.
     */
    private static void employeeTable(ArrayList<Employee> employeeList) {
        tableRow("ID", "Name", "Role", "Salary");
        dashDivider();

        if (employeeList.size() == 0) {
            System.out.printf("|%-22sNo employees in list%-21s|\n", " ", " ");
        } else {
            for (Employee employee : employeeList) {
                employee.tableRow();
            }
        }

        dashDivider();
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
}
