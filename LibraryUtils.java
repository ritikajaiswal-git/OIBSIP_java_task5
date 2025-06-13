import java.util.Scanner;

public class LibraryUtils {
    public static void adminMenu(Library library, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Book\n2. Delete Book\n3. View Books\n4. Exit");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter Book Title to Delete: ");
                    String del = scanner.nextLine();
                    library.deleteBook(del);
                    break;
                case 3:
                    library.viewBooks();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void userMenu(Library library, Scanner scanner) {
        System.out.print("Enter your name: ");
        String uname = scanner.nextLine();
        User user = library.findUser(uname);
        if (user == null) {
            System.out.println("User not found. Registering new user...");
            library.registerUser(uname);
            user = library.findUser(uname);
        }

        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View Books\n2. Issue Book\n3. Return Book\n4. Exit");
            System.out.print("Choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1:
                    library.viewBooks();
                    break;
                case 2:
                    System.out.print("Enter Book Title to Issue: ");
                    String issueTitle = scanner.nextLine();
                    Book toIssue = library.findBook(issueTitle);
                    if (toIssue != null && user.issueBook(toIssue)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Book cannot be issued.");
                    }
                    break;
                case 3:
                    if (user.returnBook()) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("No book to return.");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
