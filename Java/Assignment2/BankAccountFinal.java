/*
Sandra Papo
BankAccount.java

October 15, 2017

Assignment 2
This is the answer to the third question part 2.
*/


public class BankAccountFinal {
    
    private double balance;
    private double fee;
    private int transactionCount;
    private int freeTransactions;

    public BankAccountFinal(){
        balance = 0;
        fee = 1;//default fee is 1 dollar
        freeTransactions = 15;//default free transactions
        transactionCount = 0;
    }

    public BankAccountFinal(double initialBalance, double fee, int freeTransactions){
        balance = initialBalance;
        this.fee = fee;
        this.freeTransactions = freeTransactions;
        transactionCount = 0;
    }

    public void deposit(double amount){
        balance = balance + amount;
        transactionCount++;
    }

    public void withdraw(double amount){
        balance = balance - amount;
        transactionCount++;
    }

    public double getBalance(){
        return balance;
    }

    public void newFee(double newFee){
        fee = newFee;
    }

    public void duductMonthlyCharge(){
        balance -= (Math.max(transactionCount, freeTransactions) - freeTransactions)*fee;
        transactionCount = 0;
    }

    public static void main(String[] args){

        BankAccountFinal myAccount = new BankAccountFinal(100, 0.50,10);
        //Month 1
        System.out.println("Expected: $150.0");
        myAccount.deposit(50);
        System.out.println("Actual: $" + myAccount.getBalance());
        
        System.out.println("Expected: $100.0");
        myAccount.withdraw(50);
        System.out.println("Actual: $" + myAccount.getBalance());

        System.out.println("Expected: $500.0");
        myAccount.deposit(400);
        myAccount.duductMonthlyCharge();
        //Month 2
        System.out.println("Actual: $" + myAccount.getBalance());
        
        System.out.println("Expected: $480.0");
        for (int i = 0; i < 20; i++)
            myAccount.withdraw(1);
        System.out.println("Actual: $" + myAccount.getBalance());

        System.out.println("Expected: $475.0");  
        myAccount.duductMonthlyCharge();
        System.out.println("Actual: $" + myAccount.getBalance());  
        //Month 3
        System.out.println("Expected: $525.0"); 
        myAccount.newFee(5.00);
        for(int i = 0; i < 11; i++)
            myAccount.deposit(5);
        myAccount.duductMonthlyCharge();
        System.out.println("Actual: $" + myAccount.getBalance()); 

    }
}
