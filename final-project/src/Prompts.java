import java.util.Scanner;

public class Prompts {
    public static String removeEmployeePrompt(Scanner scanner) {
        Messages.divider();
        System.out.print("Enter ID of employee to remove: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    public static String promptForId(Scanner scanner) {
        System.out.print("Enter an id: ");

        String id = scanner.next();
        scanner.nextLine();

        return id;
    }

    public static String promptForName(Scanner scanner) {
        System.out.print("Enter a name: ");

        return scanner.nextLine();
    }

    public static double promptForSalary(Scanner scanner) {
        System.out.print("Enter a salary: ");

        // TODO: Handle if input isn't a double
        double salary = scanner.nextDouble();
        scanner.nextLine();

        return salary;
    }

    public static String promptForRole(Scanner scanner) {
        System.out.print("Enter a role: ");

        return scanner.nextLine();
    }
}
