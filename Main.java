import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Admin admin = new Admin("admin", "admin123");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Admin Login\n2. User Access\n3. Exit");
            System.out.print("Select: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Username: ");
                String uname = scanner.nextLine();
                System.out.print("Enter Password: ");
                String pass = scanner.nextLine();
                if (admin.authenticate(uname, pass)) {
                    LibraryUtils.adminMenu(library, scanner);
                } else {
                    System.out.println("❌ Incorrect admin credentials.");
                }
            } else if (choice == 2) {
                LibraryUtils.userMenu(library, scanner);
            } else if (choice == 3) {
                System.out.println("👋 Exiting. Thank you!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
