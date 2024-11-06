import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Messages {
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

    public static void invalidMenuOption() {
        System.out.println("\nInvalid option, try again please.\n");
    }

    public static void menuHeader() {
        System.out.println("Ryan Pallas - ASU ID");
        divider();
        System.out.println("Company Management System");
        divider();
    }

    public static void menuExited() {
        divider();
        System.out.println("Company Manager Exited");
        divider();
    }

    public static void addEmployeeConfirmation() {
        divider();
        System.out.println("Employee added successfully");
        currentDate();
    }

    public static void addEmployeeError(String id) {
        divider();
        System.out.printf("ID must be unique: %s\n", id);
        divider();
    }

    public static void removeEmployeeConfirmation() {
        divider();
        System.out.println("Employee removed successfully");
        currentDate();
    }

    public static void employeeDoesNotExist(String id) {
        divider();
        System.out.printf("No employee exists for ID: %s\n", id);
        divider();
    }

    public static void displayEmployeeList(ArrayList<Employee> employeeList) {
        dashDivider();
        System.out.printf("%-25sEmployee List\n", " ");
        dashDivider();
        tableRow("ID", "Name", "Role", "Salary");
        dashDivider();

        if (employeeList.size() == 0) {
            System.out.printf("|%-22sNo employees in list%-19s|\n", " ", " ");
        } else {
            for (Employee employee : employeeList) {
                tableRow(employee.getEmployeeID(), employee.getEmployeeName(), employee.getRole(),
                        employee.getSalary());
            }
        }
        dashDivider();
    }

    public static void displaySalaryReport(ArrayList<Employee> employeeList) {
        double totalSalary = 0;

        for (Employee employee : employeeList) {
            totalSalary += employee.getSalary();
        }

        displayEmployeeList(employeeList);
        System.out.printf("Total Salary: %.1f\n", totalSalary);
    }

    public static void divider() {
        System.out.println("=".repeat(35));
    }

    private static void dashDivider() {
        System.out.println("-".repeat(65));
    }

    private static void tableRow(String id, String name, String role, double salary) {
        System.out.printf("| %-10s | %-15s | %-15s | %-12.2f |\n", id, name, role, salary);
    }

    private static void tableRow(String id, String name, String role, String salary) {
        System.out.printf("| %-10s | %-15s | %-15s | %-12s |\n", id, name, role, salary);
    }

    private static void currentDate() {
        divider();
        System.out.printf("Current time: %s\n", getDateAndTime());
        divider();
    }

    // private static String getDate() {
    // Date date = new Date();
    // SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    // String currentDate = dateFormat.format(date);
    // return currentDate;
    // }

    private static String getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String currentDate = dateFormat.format(date);
        return currentDate;
    }
}