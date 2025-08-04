public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(double overdraftLimit) { this.overdraftLimit = overdraftLimit; }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= -overdraftLimit) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nAccount Type: Checking" +
               "\nOverdraft Limit: $" + overdraftLimit;
    }
}
