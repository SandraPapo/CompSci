
/*
Author: Sandra Papo
Date: 09/27/2017

Problem 6. (4 points)
What are the values of the following expressions? In each line assume that
double x = 2.5;
double y = -1.5;
int n = 17;
int m = 18;
a. x + n * y – (x + n) * y
b. m / n + m % n
c. n % 2 + m % 2
d. (m + n) / 2
e. (m + n) / 2.0;
f. (int) (0.5 * (m + n))
g. 1 - (1 - (1 - n))
h. n % 10 + (n – (n % 10))

Answer:
a. 6.25
b. 2
c. 1
d. 17
e. 17.5
f. 17
g. -16
h. 17

Code used to verify is below:
*/
public class Problem6 {
    public static void main( String[] args ) {
		double x = 2.5;
		double y = -1.5;
		int n = 17;
		int m = 18;
		System.out.println("a. " + (x + n * y - (x + n) * y));
		System.out.println("b. " + (m / n + m % n));
		System.out.println("c. " + (n % 2 + m % 2));
		System.out.println("d. " + ((m + n) / 2));
		System.out.println("e. " + ((m + n) / 2.0));
		System.out.println("f. " + ((int) (0.5 * (m + n))));
		System.out.println("g. " + (1 - (1 - (1 - n))));
		System.out.println("h. " + (n % 10 + (n - (n % 10))));

    }
}
