/*
Sandra Papo
P3.java

November 5, 2017

Assignment 3
This is the answer to the third question.
*/

import java.util.Scanner;

class TicTacToe {
	private char[][] board;
	private int currentPlayer;
	private int numPlays;

	public TicTacToe() {
		board = new char[3][3];
		currentPlayer = 0;
		numPlays = 0;
	}

	public int getCurrentPlayer(){
		return currentPlayer;
	}

	public void play(int x, int y) {
		if(board[x][y] == 'o' || board[x][y] == 'x'){
			System.out.println("Spot taken, try again");
			return;
		}
		if (currentPlayer == 0) {
			board[x][y] = 'o';
		}
		else {
			board[x][y] = 'x';
		}

		currentPlayer = (currentPlayer + 1) % 2;
		numPlays++;
	}

	public int checkIfOver(){
		for (int i = 0; i < 3; i++) {
			if((board[i][0] == 'o' || board[i][0] == 'x') && board[i][0] == board[i][1] && board[i][1] == board[i][2])
				return 1;
			if((board[0][i] == 'o' || board[0][i] == 'x') && board[0][i] == board[1][i] && board[1][i] == board[2][i]) 
				return 1;
		}

		if ((board[0][0] == 'o' || board[0][0] == 'x') && board[0][0] == board[1][1] && board[1][1] == board[2][2])
			return 1;
		if ((board[2][0] == 'o' || board[2][0] == 'x') && board[2][0] == board[1][1] && board[1][1] == board[0][2]) 
			return 1;
		if (numPlays >= 9)
			return 2;
		return 0;
	}

	public void printBoard() {
		System.out.println("  x0   x1  x2  ");
		for (int i = 0; i < 3; i++) {
			System.out.print("y" + i);
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != 'o' && board[i][j] != 'x')
					System.out.print("   ");
				else 
					System.out.print(" " + board[i][j] + " ");

				if (j < 2)
					System.out.print("|");

			}
			if (i < 2)
				System.out.println("\n   ---------- ");
		}
		System.out.println("");
	}
}

public class P3 {	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		int status = 0;
		int x, y;
		Scanner sc = new Scanner(System.in);
		while(status == 0) {
			game.printBoard();
			System.out.print("Player " + (game.getCurrentPlayer() + 1)+ ", Enter coordinates in form \"x y\" ex) \"0 1\":");
			x = sc.nextInt();
			y = sc.nextInt();
			if((x< 0 || x>2) && (y< 0 || y>2)){
				System.out.println("Invalid input, try again...");
				continue;
			}

			game.play(y,x);
			status = game.checkIfOver();
		}
		
		game.printBoard();
		if(status == 2)
			System.out.println("It is a tie");
		else
			System.out.println("Player " + ((game.getCurrentPlayer() + 1)%2 +1) + " wins!!");
	
	}

}