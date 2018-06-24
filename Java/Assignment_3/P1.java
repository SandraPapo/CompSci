/*
Sandra Papo
P1.java

November 5, 2017

Assignment 3
This is the answer to the first question.
*/

import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {

		String testValue1 = "4012 8888 8888 1881";
		if (validate(testValue1))
			System.out.println("Card Number: " + testValue1 + " is Valid.");
		else
			System.out.println("Card Number: " + testValue1 + " is Invalid.");
		System.out.println("Expected: Valid");

		String testValue2 = "sdaf dssa dkdk dkdd";
		if (validate(testValue2))
			System.out.println("Card Number: " + testValue2 + " is Valid.");
		else
			System.out.println("Card Number: " + testValue2 + " is Invalid.");
		System.out.println("Expected: Invalid");


		String testValue3 = "1111 2222 3333 4444";
		if (validate(testValue3))
			System.out.println("Card Number: " + testValue3 + " is Valid.");
		else
			System.out.println("Card Number: " + testValue3 + " is Invalid.");
		System.out.println("Expected: Valid");

		String testValue4 = "1512 1211 1111 1111";
		if (validate(testValue4))
			System.out.println("Card Number: " + testValue4 + " is Valid.");
		else
			System.out.println("Card Number: " + testValue4 + " is Invalid.");
		System.out.println("Expected: Valid");

	}
	 /*
	 Check if input is a valid card number.
	 @param inputNumber to check whether it is valid
	 @return true if inputNumber is valid
	 */
	private static boolean validate(String inputNumber) {
		String cardNumber = inputNumber.replaceAll("\\s","");
		// If the card is actually a number...
		try {
			Long.parseLong(cardNumber);
		}
		
		catch(Exception e){
			return false;
		}


		int totalValue = 0;

		for(int i = cardNumber.length() - 1; i >= 0; i--) {
			int currentValue = Character.getNumericValue(cardNumber.charAt(i));
			if (((cardNumber.length() - 1 - i) % 2) == 1) {
				totalValue += currentValue * 2;
				if ( currentValue > 4)
					totalValue++;
			}
			else
				totalValue += currentValue;

		}

		if ((totalValue % 10) == 0)
			return true;
		else
			return false;

	}
}