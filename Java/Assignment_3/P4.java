/*
/*
Sandra Papo
P4.java

November 5, 2017

Assignment 3
This is the answer to the fourth question.
*/

import java.util.Scanner;

class Terrain {
	private int[][] heights;
	private int waterLevel;
	private int size;

	public Terrain(int size, int waterLevel){
		this.size = size;
		heights = new int[size][size];
		this.waterLevel = waterLevel;
	}

	public void setHeights(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the heights in the following form: ");
		System.out.println("1 2 3 4\n5 6 7 8\n9 10 11 12\n13 14 15 16");
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				heights[i][j] = sc.nextInt();
			}
		}
	}

	public int highestPoint(){
		int max = heights[0][0];
		for (int i = 0; i < size; i++){
			for (int j = 0;j < size ; j++) {
				if(heights[i][j] > max)
					max = heights[i][j];
			}
		}
		return max;
	}

	public int lowestPoint(){
		int min = heights[0][0];
		for (int i = 0; i < size; i++){
			for (int j = 0;j < size ; j++) {
				if(heights[i][j] < min)
					min = heights[i][j];
			}
		}
		return min;
	}

	public void printFloodMap(){
		for (int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {		
				if(waterLevel > heights[i][j])
					System.out.print('*');
				else
					System.out.print('-');
			}
			System.out.println("");
		}

	}

}

public class P4 {	
	public static void main(String[] args) {
		Terrain myTerrain = new Terrain(4, 6);
		myTerrain.setHeights();
		System.out.println(myTerrain.lowestPoint());
		System.out.println(myTerrain.highestPoint());
		myTerrain.printFloodMap();

	}

}