public class Bank {
    private double balance = 100;

    public Bank(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException
    {
        if (balance<amount){
            throw  new InsufficientFundsException("InsufficientFundsException");

        }
        balance -= amount;
    }
}
