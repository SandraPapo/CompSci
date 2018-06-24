/*
Winter is coming - but without the need for high walls and plans for the undead. Our non-human counterparts are those little squirrels you see running around everywhere, and they're getting ready for the changing temperatures. 

Squirrels collect and burrow nuts in the ground in preparation for the snow-covered months. Before burying their edible treasure into the ground, they leave their scent on the food in order to find the hole later (more on squirrels here). Squirrels can even smell their treats buried under a foot of snow. With the scarcity of food in the winter months, however, comes competition from other squirrels. 

This winter, the squirrels will only move into a new area if they can determine that there are at least C unique pairs of holes, where in each pair there is exactly S chestnuts. You will be given an unsorted array of length N, which contains the number of chestnuts present in each hole. Each element in the array represents one hole in the area. 

Your task is to determine whether there are at least C unique hole pairings, with each pair summing to exactly S (picky squirrels). 

Input:
Array of size N where 1 <= N <= 10x2^6 and each hole (array element) contains H chestnuts where 1 <= H <= 50
C, where 1 <= C <= 1000
S, where 2 <= S <= 100

Output:
Boolean value for whether there are at least C unique pairs 

----------
Ex1
Input: [1,1,2], 2, 3
Output: True

Ex 2
Input: [1,2,9,1,5,7,2,6,9,3], 6, 10
Output: False

Optimal solution is O(n). 
*/

import java.util.Scanner;
import java.util.Arrays;

class SquirrelArea{
	private int[] holes;
	private int numUniquePairs;
	private int sumPair;

	public SquirrelArea(String input){
		String[] holeString = input.substring(input.indexOf('[')+1, input.indexOf(']')).replaceAll("\\s", "").split(",");
		String[] info = input.substring(input.indexOf(']') + 1).replaceFirst(",", "").replaceAll("\\s", "").split(",");

		numUniquePairs = Integer.parseInt(info[0]);
		sumPair = Integer.parseInt(info[1]);
		holes = new int[holeString.length];
		for(int i = 0; i < holeString.length; i++){
			holes[i] = Integer.parseInt(holeString[i]);
		}
	}

	public void printValues(){
		System.out.println("holes: " + Arrays.toString(holes) + " unique pairs: " + numUniquePairs + " sum pair: " + sumPair);
	}
}

public class POTW1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		SquirrelArea newArea = new SquirrelArea(input);
		newArea.printValues();

	}
}