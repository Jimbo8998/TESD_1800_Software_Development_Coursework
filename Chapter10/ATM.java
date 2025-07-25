import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        while (true) {
            System.out.print("Enter an id (0–9): ");
            int id = input.nextInt();

            if (id < 0 || id >= accounts.length) {
                System.out.println("Invalid ID. Try again.");
                continue;
            }

            while (true) {
                System.out.println("\nMain menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                int choice = input.nextInt();

                if (choice == 1) {
                    System.out.printf("The balance is %.2f\n", accounts[id].getBalance());
                } else if (choice == 2) {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = input.nextDouble();
                    accounts[id].withdraw(amount);
                } else if (choice == 3) {
                    System.out.print("Enter amount to deposit: ");
                    double amount = input.nextDouble();
                    accounts[id].deposit(amount);
                } else if (choice == 4) {
                    System.out.println("Logging out...\n");
                    break; // Exit to ID prompt
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
