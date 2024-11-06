
import java.util.Scanner;
import java.util.ArrayList;

public class CompanyManager {
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        start(scanner);

        scanner.close();
    }

    public static void start(Scanner scanner) {
        int option = -1;

        Messages.menuHeader();

        while (option != 0) {
            Messages.displayMenu();

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    Messages.menuExited();
                    break;
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    removeEmployee(scanner);
                    break;
                case 3:
                    updateRole(scanner);
                    break;
                case 4:
                    updateSalary(scanner);
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

    public static void addEmployee(Scanner scanner) {
        // Create a new employee and as for required information
        Employee employee = createEmployee(scanner);

        employeeList.add(employee);

        Messages.addEmployeeConfirmation();
    }

    public static void removeEmployee(Scanner scanner) {
        String id;
        Employee employee;

        id = Prompts.removeEmployeePrompt(scanner);
        employee = getEmployeeById(id);

        if (employee != null) {
            employeeList.remove(employee);
            Messages.removeEmployeeConfirmation();
        }
    }

    public static void updateRole(Scanner scanner) {
        Employee employee;
        String role;
        String id = Prompts.promptForId(scanner);

        employee = getEmployeeById(id);

        if (employee != null) {
            role = Prompts.promptForRole(scanner);
            employee.setRole(role);
        }
    }

    public static void updateSalary(Scanner scanner) {
        Employee employee;
        double salary;
        String id = Prompts.promptForId(scanner);

        employee = getEmployeeById(id);

        if (employee != null) {
            salary = Prompts.promptForSalary(scanner);
            employee.setSalary(salary);
        }
    }

    private static Employee createEmployee(Scanner scanner) {
        String id = getEmployeeId(scanner);
        String name = Prompts.promptForName(scanner);
        double salary = Prompts.promptForSalary(scanner);
        String role = Prompts.promptForRole(scanner);

        return new Employee(id, name, salary, role);
    }

    private static Employee getEmployeeById(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeID().equals(id)) {
                return employeeList.get(i);
            }
        }

        Messages.employeeDoesNotExist(id);
        return null;
    }

    private static boolean doesEmployeeExist(String id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeID().equals(id)) {
                return true;
            }
        }

        return false;
    }

    private static String getEmployeeId(Scanner scanner) {
        String id;
        boolean doesIdExist;

        id = Prompts.promptForId(scanner);
        doesIdExist = (doesEmployeeExist(id));

        while (doesIdExist) {
            Messages.addEmployeeError(id);
            id = Prompts.promptForId(scanner);
            doesIdExist = doesEmployeeExist(id);
        }

        return id;
    }
}
