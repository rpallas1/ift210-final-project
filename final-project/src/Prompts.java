import java.util.Scanner;

/**
 * Utility class that provides various prompts for user input.
 * Used to gather data like menu options, employee information, and other
 * details from the user.
 */
public class Prompts {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to select a menu option by displaying available options.
     * 
     * @return the integer selected by the user representing the chosen menu option
     */
    public static int promptForMenuOption() {
        Messages.displayMenu();

        int option = scanner.nextInt();
        scanner.nextLine();

        return option;
    }

    /**
     * Prompts the user to enter the ID of an employee to remove.
     * 
     * @return a String representing the employee ID entered by the user
     */
    public static String removeEmployeePrompt() {
        Messages.divider();
        System.out.print("Enter ID of employee to remove: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter an ID.
     * 
     * @return a String representing the ID entered by the user
     */
    public static String promptForId() {
        System.out.print("Enter an id: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter an ID, with the option to return to the menu by
     * entering 0.
     * 
     * @return a String representing the ID entered by the user
     */
    public static String promptForUniqueId() {
        System.out.print("Enter an id (Enter 0 to return to menu): ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter an ID of the employee having its role updated.
     * 
     * @return a String representing the ID entered by the user
     */
    public static String promptForUpdateRoleId() {
        System.out.print("Enter ID of employee to update role: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter an ID of the employee having its salary updated.
     * 
     * @return a String representing the ID entered by the user
     */
    public static String promptForUpdateSalaryId() {
        System.out.print("Enter ID of employee to update salary: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    /**
     * Prompts the user to enter a name.
     * 
     * @return a String representing the name entered by the user
     */
    public static String promptForName() {
        System.out.print("Enter a name: ");

        // TODO: Validate name
        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a salary.
     * 
     * @return a double representing the salary entered by the user
     */
    public static double promptForSalary() {
        System.out.print("Enter a salary: ");

        // TODO: Validate salary
        double salary = scanner.nextDouble();
        scanner.nextLine();

        return salary;
    }

    /**
     * Prompts the user to enter an updated salary.
     * 
     * @return a double representing the salary entered by the user
     */
    public static double promptForUpdatedSalary() {
        System.out.print("Enter the updated salary: ");

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
    public static String promptForRole() {
        System.out.print("Enter a role: ");

        return scanner.nextLine();
    }

    /**
     * Prompts the user to enter a role.
     * 
     * @return a String representing the role entered by the user
     */
    public static String promptForUpdatedRole() {
        System.out.print("Enter the updated role: ");

        return scanner.nextLine();
    }
}
