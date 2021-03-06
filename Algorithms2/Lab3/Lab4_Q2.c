/*
Author: Sandra Papo
Date: 05/10/2017

The answer to number 5
*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define SUITS 4
#define FACES 13
#define CARDS 52

void shuffle(unsigned int wDeck[][FACES]);
void deal(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]);
int containsPair(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]);
int containsTwoPair(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]);
int containsThreeOfAKind(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]);
int containsFourOfAKind(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]);
int containsFlush(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]);
int containsStraight(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]);

int main(void){
	unsigned int deck[SUITS][FACES] = {0};
	srand(time(NULL));

	shuffle(deck);
	shuffle(deck);

	const char *suit[SUITS] = {"Hearts", "Diamonds", "Clubs", "Spades"};
	const char *face[FACES] = {"Ace", "Duece", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

	int currentHand[5][2];
	
	deal(deck, face, suit, currentHand);

	printf("\n\nContains Pair: ");
	(containsPair(deck, face, suit, currentHand) == 0)? printf("false\n"):printf("true\n");
	printf("Contains Two Pair: ");
	(containsTwoPair(deck, face, suit, currentHand) == 0)? printf("false\n"):printf("true\n");;
	printf("Contains Three of a Kind: ");
	(containsThreeOfAKind(deck, face, suit, currentHand) == 0)? printf("false\n"):printf("true\n");;
	printf("Contains Four of a Kind: ");
	(containsFourOfAKind(deck, face, suit, currentHand) == 0)? printf("false\n"):printf("true\n");;
	printf("Contains Flush: ");
	(containsFlush(deck, face, suit, currentHand) == 0)? printf("false\n"):printf("true\n");;
	printf("Contains Straight: ");
	(containsStraight(deck, face, suit, currentHand) == 0)? printf("false\n"):printf("true\n");;

}


void shuffle(unsigned int wDeck[][FACES]){
	int card = 1;

	for(int i = 0; i < SUITS; ++i) {
		for (int j = 0; j < FACES; ++j) {
			wDeck[i][j] = card++;
			printf("%3i ", wDeck[i][j]);
		}
		printf("\n");
	}
	printf("\n");
	unsigned i1;
	unsigned i2;
	unsigned temp;
	
	for(int i = 0; i < SUITS; ++i) {
		for (int j = 0; j < FACES; ++j) {
			temp = wDeck[i][j];
			i1 = rand() % SUITS;
			i2 = rand() % FACES;
			wDeck[i][j] = wDeck[i1][i2];
			wDeck[i1][i2] = temp;
		}
	}

	for(int i = 0; i < SUITS; ++i) {
		for (int j = 0; j < FACES; ++j) {
			printf("%3i ", wDeck[i][j]);
		}
		printf("\n");
	}
	printf("\n");

}


void deal(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]) {
//faces then suits
	for (int card = 1; card <= 5; ++card) {
		int breakLoop = 0;
		for (int row = 0; row < SUITS; ++row) {
			for (int column = 0; column < FACES; ++column) {
				if(wDeck[row][column] == card){
					printf("%5s of %-8s%c",wFace[column], wSuit[row], card %2 == 0 ? '\n':'\t');
					currentHand[card - 1][0]= column;
					currentHand[card - 1][1]= row;	
					breakLoop = 1;
					break;
				}
				if (breakLoop == 1)
					break;
			}
		}
	}


}

int containsPair(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]){

	int checkPairs[13] = {0};
	for (int i = 0; i < 5; ++i) {
		checkPairs[currentHand[i][0]]++;
	}
	int numPairs = 0;
	for (int i = 0; i < 13; ++i) {
		if(checkPairs[i] == 2)
			numPairs++;
	}

	if(numPairs == 1)
		return 1;
	else 
		return 0;
}
int containsTwoPair(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]){

	int checkPairs[13] = {0};
	for (int i = 0; i < 5; ++i) {
		checkPairs[currentHand[i][0]]++;
	}
	int numPairs = 0;
	for (int i = 0; i < 13; ++i) {
		if(checkPairs[i] == 2)
			numPairs++;
	}

	if(numPairs == 2)
		return 1;
	else 
		return 0;
}

int containsThreeOfAKind(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]){

	int checkPairs[13] = {0};
	for (int i = 0; i < 5; ++i) {
		checkPairs[currentHand[i][0]]++;
	}

	for (int i = 0; i < 13; ++i) {
		if(checkPairs[i] == 3)
			return 1;
	}

	return 0;
}

int containsFourOfAKind(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]){

	int checkPairs[13] = {0};
	for (int i = 0; i < 5; ++i) {
		checkPairs[currentHand[i][0]]++;
	}

	for (int i = 0; i < 13; ++i) {
		if(checkPairs[i] == 4)
			return 1;
	}

	return 0;
}

int containsFlush(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]){

	int checkSuits[5] = {0};
	for (int i = 0; i < 5; ++i) {
		checkSuits[currentHand[i][1]]++;
	}

	for (int i = 0; i < 4; ++i) {
		if(checkSuits[i] == 5)
			return 1;
	}

	return 0;
}

int containsStraight(unsigned int wDeck[][FACES], const char *wFace[], const char *wSuit[], int currentHand[5][2]){

	int checkFaces[13] = {0};
	
	for (int i = 0; i < 5; ++i) {
		checkFaces[currentHand[i][0]]++;
	}

	int straightCount = 0;
	for (int i = 0; i < 13; ++i) {
		if(straightCount == 5)
			return 1;
		else if(checkFaces[i] == 1)
			straightCount++;
		else
			straightCount = 0;
	}

	return 0;
}
