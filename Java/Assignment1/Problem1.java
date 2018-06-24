/*
Author: Sandra Papo
Date: 09/27/2017

The code implemented solves the following question: 

First update the pseudocode we discussed in class (and textbook) for the account with interest rate,
and then write a Java program for that to print the balance of an account after the first, second and third year,
if the initial balance is $1,000 and earns 5% interest per year. Complete your code by putting a general
document about your program at the top of the code as well as documents for the variables and statements
inside your program.
*/

public class Problem1 {
    public static void main( String[] args ) {
    	double balance = 1000;	// initializing account balance
    	double interest = 0.05; // initializing the interest

    	for (int i = 1; i <= 3; i++ ) { // iterates through 3 cycles
    		balance = balance*1.05;		// updates the balance
    		System.out.printf("The balance of year %d is $%.2f \n", i, balance); //prints the formatted balance and year
    	}
    }
}
