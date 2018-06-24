/*
Author: Sandra Papo
Date: 09/27/2017

Problem 2. (4 points)
The ancient Babylonians had an algorithm for determining the square root of a number a. Start with
an initial guess of a/2. Then find the average of your guess g and a/g. That’s your next guess. Repeat until
two consecutive guesses are close enough, e.g. less than a threshold t. Write pseudocode for this algorithm.

Pseudocode:


guess = a/2
nextGuess = (guess + a/guess)/2

while(absolute(guess - nextGuess) > t){
	guess = nextGuess
	nextGuess = (guess + a/guess)/2
}

squareroot = guess

code actually implemented below
*/

public class Problem2 {
    public static void main( String[] args ) {
    	double a = 16;
        double guess = a/2;
        double nextGuess = (guess + a/guess)/2;
	while(Math.abs(guess - nextGuess) > 0.001){
		guess = nextGuess;
		nextGuess = (guess + a/guess)/2;
	}
	System.out.printf("%.2f\n", nextGuess);
    }
}
