/*
Author: Sandra Papo
Date: 09/27/2017

The code implemented solves the following question: 

Problem 5. (6 points)
Write a Java program, in which declare and initialize required variables and compute the following
mathematical operations:
s = s0 + v0 + 1/2(g*t^2)
G = 4*pi^2(a^3/(p^2*(m1+m2)))
*/
import java.text.DecimalFormat;

public class Problem5 {
    public static void main( String[] args ) {
        //initalizing variables
    	double s0 = 1,v0 = 1,g = 1,t = 1;  // first equation
    	double a = 1,p = 1, m1 = 1, m2 = 1;    // second equation

        //implementing equations
    	double s = s0 + v0 + 1/2*(g*Math.pow(t,2));
    	double bigG = 4*Math.pow(Math.PI,2)*(Math.pow(a,3)/(Math.pow(p,2)*(m1+m2)));
		
        //formatting output
		DecimalFormat df = new DecimalFormat("#.##");
    	
        //displaying result to screen
    	System.out.println("s is " + df.format(s) + " and G is " + df.format(bigG));
    }
}
