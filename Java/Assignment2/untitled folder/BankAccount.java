
/**
 * Created by sandrapapo on 2017-10-15.
 */

public class BankAccount {
    private double balance;
    private double fee;

    public BankAccount(){
        balance = 0;
        fee = 1;//default fee is 1 dollar
    }

    public BankAccount(double initialBalance, double fee){
        balance = initialBalance;
        this.fee = fee;
    }

    public void deposit(double amount){
        balance = balance + amount;
        balance -= fee;
    }

    public void withdraw(double amount){
        balance = balance - amount;
        balance -= fee;
    }

    public double getBalance(){
        return balance;
    }

    public void newFee(double newFee){
        fee = newFee;
    }
    public static void main(String[] args){

        BankAccount myAccount = new BankAccount(100, 0.50);

        System.out.println("Expected: $149.50");
        myAccount.deposit(50);
        System.out.println("Actual: $" + myAccount.getBalance());
        System.out.println("Expected: $99.00");
        myAccount.withdraw(50);
        System.out.println("Actual: $" + myAccount.getBalance());

    }
}
