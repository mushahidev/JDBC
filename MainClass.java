package Task81624;

import java.util.Scanner;

public class MainClass {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DatabaseConnection dbc = new DatabaseConnection();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nUser Management System");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Remove User");
            System.out.println("4. Display All Users");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    removeUser();
                    break;
                case 4:
                    displayUser();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addUser() {
        System.out.print("Enter userName: ");
        String userName = scanner.nextLine();

        System.out.print("Enter firstName: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter lastName: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        UserData user = new UserData(userName, firstName, lastName, city);
        dbc.addUser(user);
    }

    private static void updateUser() {
        System.out.print("Enter userId to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new userName: ");
        String userName = scanner.nextLine();

        System.out.print("Enter new firstName: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter new lastName: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter new city: ");
        String city = scanner.nextLine();

        UserData user = new UserData(userName, firstName, lastName, city);
        dbc.updateUser(user);
    }

    private static void removeUser() {
        System.out.print("Enter userId to remove: ");
        int userId = scanner.nextInt();
        dbc.removeUser(userId);
    }

    private static void displayUser() {
        dbc.displayUser();
    }
}
