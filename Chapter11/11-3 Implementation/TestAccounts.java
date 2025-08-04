public class TestAccounts {
    public static void main(String[] args) {
        // Base Account
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);

        // Savings Account
        SavingsAccount savings = new SavingsAccount(2233, 5000);
        savings.setAnnualInterestRate(3.5);
        savings.withdraw(6000); // Should deny withdrawal

        // Checking Account
        CheckingAccount checking = new CheckingAccount(3344, 1000, 500);
        checking.setAnnualInterestRate(4.0);
        checking.withdraw(1300); // Allowed up to -500 overdraft

        // Output
        System.out.println("=== Base Account ===");
        System.out.println(account.toString());
        System.out.println("\nMonthly Interest: $" + account.getMonthlyInterest());

        System.out.println("\n=== Savings Account ===");
        System.out.println(savings.toString());
        System.out.println("\nMonthly Interest: $" + savings.getMonthlyInterest());

        System.out.println("\n=== Checking Account ===");
        System.out.println(checking.toString());
        System.out.println("\nMonthly Interest: $" + checking.getMonthlyInterest());
    }
}
