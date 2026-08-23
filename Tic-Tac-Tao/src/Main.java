import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();
        while (true){
            System.out.println("\n===== TIC TAC TOE =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                int password = sc.nextInt();
                boolean registered =userService.register(username, password);
                if (registered) {
                    System.out.println("Registration successful!");
                } else {
                    System.out.println("Username already exists!");
                }
            }
            else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = sc.next();
                System.out.print("Enter password: ");
                int password = sc.nextInt();
                User user=userService.login(username, password);
                if (user != null) {
                    System.out.println("Login successful!");
                    showMenu(sc, user);
                }
                else {
                    System.out.println("Invalid username or password!");
                }
            }
            else if (choice == 3) {
                System.out.println("Thank you for playing!");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }
    public static void showMenu(Scanner sc, User user) {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Host Game");
            System.out.println("2. Play With Friend");
            System.out.println("3. Play With Computer");
            System.out.println("4. View Profile");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.print("Enter second player name: ");
                String player2 = sc.next();
                TicTacToe game = new TicTacToe();
                game.startGame(user.getUsername(), player2);
            }
            else if (option == 2) {
                System.out.print("Enter your friend's name: ");
                String friendName = sc.next();
                TicTacToe game = new TicTacToe();
                game.startGame(
                        user.getUsername(),
                        friendName
                );
            }
            else if (option == 3) {
                System.out.println("Computer mode is not implemented yet.");
                System.out.println("You can add a Computer class later.");
            }
            else if (option == 4) {
                System.out.println("\n===== PROFILE =====");
                System.out.println("Username: " + user.getUsername());
            }
            else if (option == 5) {
                System.out.println("Logged out successfully!");
                break;
            }
            else {
                System.out.println("Invalid option!");
            }
        }
    }
}