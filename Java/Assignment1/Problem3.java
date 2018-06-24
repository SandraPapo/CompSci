/*
Author: Sandra Papo
Date: 09/27/2017

The code implemented solves the following question: 

Problem 3. (4 points)
Write a Java program to compute and print the sum and multiplication of the first five negative
integers, starting from -1, -2, …. Add document to your code.
*/

public class Problem3 {
    public static void main( String[] args ) {
    	//initializations
    	double sum = 0;	
    	double product = 1;	

    	//for loop cycles from -1 to -5
    	for(int i = -1; i >= -5; i--){
    		sum = sum + i; //computes sum
    		product = product * i; //computes product
    	}
    	
    	System.out.println("The sum is " + sum + " and the product is " + product); // prints final product and sum to screen
    }
}
