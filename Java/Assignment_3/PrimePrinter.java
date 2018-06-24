/*
Sandra Papo
PrimePrinter.java

November 5, 2017

Assignment 3
This is the answer to the second question.
*/
 import java.util.Scanner;
/*
 This class generates all prime numbers.
*/
class PrimeGenerator {
	
	 private int current;
	
	 public PrimeGenerator() {
	 	current = 1;
	 }
	 /*
	 Calculates the next prime number.
	 @return the next prime number
	 */
	 public int nextPrime() {
	 // Complete this part
	 	if(current == 1) {
	 		current = 2;
	 		return current;
	 	}

	 	int next = current;
	 	boolean isPrime = false;
	 	while(isPrime != true){
	 		next++;
	 		for (int i = 2; i < next; i++) {
	 			if(next % i == 0)
	 				break;
	 			if(i == next - 1)
	 				isPrime = true;
	 		}
	 	}
	 	current = next;
	 	return current;
	 }
	 /*
	 Check if n is a prime number.
	 @param n to check whether it is prime or not
	 @return true if n is prime
	 */
	public static boolean isPrime(int n) {
	 // Complete this part
		if(n == 1 || n == 2) {
			return true;
		}

	 	for (int i = 2; i < n; i++) {
	 		if(n % i == 0)
	 			return false;
	 	}		
		return true;

	}
}

	/*
	 This class prints prime numbers.
	*/
public class PrimePrinter {
	 public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter upper limit: ");
		int limit = in.nextInt();
		// Complete this part
		PrimeGenerator myPrime = new PrimeGenerator();
		
		int prime = myPrime.nextPrime();
		while(prime < limit) {
			System.out.println(prime);
			prime = myPrime.nextPrime();
		}
		
		if(myPrime.isPrime(limit)) {
			System.out.println(limit);
		}



	 }
}