
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    public static void displayMenu(String name) {
        System.out.println("\n" + name + " Brokerage Account");
        System.out.println();
        System.out.println("0 - Exit");
        System.out.println("1 - Deposit Cash");
        System.out.println("2 - Withdraw Cash");
        System.out.println("3 - Show Balance");
        System.out.println("4 - Display Transaction History");
        System.out.println("5 -Display Portfolio ");
        System.out.println("Enter Choice: ");
    }

    public static void start(Scanner s) {
        int option = -1;

        System.out.println(" Select one choice and 0 to exit:");

        while (option != 0) {
            displayMenu("Your Name");

            option = s.nextInt();

            s.nextLine();

            switch (option) {
                case 1:
                    depositCash();
                    break;
                case 2:
                    withdrawCash();
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    displayTransactionHistory();
                    break;
                case 5:
                    displayPortfolio();
                    break;
                default:
                    System.out.println("\nInvalid option, try again please.\n");
            }
        }
    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String currDate = dateFormat.format(date);
        return currDate;
    }

    public static String getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String currDate = dateFormat.format(date);
        return currDate;
    }

    public static void depositCash() {
        System.out.println("This method will do task to deposit Cash");
    }

    public static void withdrawCash() {
        System.out.println("This method will do task to withdraw  Cash");
    }

    public static void buyStock() {
        System.out.println("This method will do task to buy stock");
    }

    public static void showBalance() {
        System.out.println("This method will do task to show balance");
    }

    public static void displayTransactionHistory() {
        System.out.println("This method will do task to  display transaction history");
    }

    public static void displayPortfolio() {
        System.out.println("This method will do task to display Portfolio ");
        System.out.println("Only Date:" + getDate());
        System.out.println("Date: and Time :" + getDateAndTime());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        start(scanner);

        scanner.close();
    }
}
