package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
    public int compareTo(Object otherPlayer) {
        Player other = (Player) otherPlayer;
        return goalsScored - otherPlayer.goalsScored;
    }