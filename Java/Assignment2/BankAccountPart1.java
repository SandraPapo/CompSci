/*
Sandra Papo
BankAccount.java

October 15, 2017

Assignment 2
This is the answer to the third question part 1.
*/

public class BankAccountPart1 {
    private double balance;
    private double fee;

    public BankAccountPart1(){
        balance = 0;
        fee = 1;//default fee is 1 dollar
    }

    public BankAccountPart1(double initialBalance, double fee){
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

        BankAccountPart1 myAccount = new BankAccountPart1(100, 0.50);

        System.out.println("Expected: $149.50");
        myAccount.deposit(50);
        System.out.println("Actual: $" + myAccount.getBalance());
        System.out.println("Expected: $99.00");
        myAccount.withdraw(50);
        System.out.println("Actual: $" + myAccount.getBalance());

    }
}
