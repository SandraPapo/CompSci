/*Write a Java program that reads a word and prints the word in reverse. For example, if the user provides the input: 

Harry

the program prints

yrraH

At the end, indicate if the input word is a palindrome, i.e. reads the same backward as forward, e.g., madam.*/

import java.util.Scanner;

public class Activity1{
	public static void main(String[] args){
		Scanner myScanner = new Scanner(System.in);
		
		String word = myScanner.nextLine();

		String wordReversed = "";

		for(int i = 0; i < word.length(); i++){
			wordReversed += word.charAt((word.length() - 1 ) - i);
		}

		System.out.println(wordReversed);

		if(word.equals(wordReversed))
			System.out.println("It is a palindrome");
		else
			System.out.println("It is not a palindrome");
	}
}
