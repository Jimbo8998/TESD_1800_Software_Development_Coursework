public class SavingsAccount extends Account {

    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= 0) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Withdrawal denied! Savings account cannot be overdrawn.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nAccount Type: Savings";
    }
}
