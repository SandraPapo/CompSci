/*
Name: Sandra Papo
SN: 104213584
Date: October 19th, 2017
104213594_AirlineResSystem.c
this is the solution to the second question in the assignment
 */ 
#include <stdio.h> 

int main(void) { 
	//initialization
	int seats[10] = {0};
	int firstClass = 0;
	int economyClass = 5;

	//while the plane is not full
	while (!(firstClass == 5 && economyClass == 10)){
		//prints out the current seating in a visual way
		printf("Currently the seats are assigned as follows from 1 -> 10 (0 is available and 1 is occupied)\n");
		for(int i = 0; i < 10; i++){
			printf("%i\t",seats[i] );
		}

		//gets seat type from user
		printf("\nPlease type 1 for \"first class\"\nPlease type 2 for \"economy\"\n");
		int selection;
		scanf("%i", &selection);

		//decides on next action based of given selection
		if(selection == 1 && firstClass < 5){
			seats[firstClass] = 1;
			printf("\nBoarding Pass: Seat number %i in First Class\n\n", firstClass+1);
			++firstClass;
		}
		else if(selection == 1 && firstClass == 5){
			printf("First Class is Full. Type 2 to switch to Economy \n");
		}
		else if(selection == 2 && economyClass < 10){
			seats[economyClass] = 1;
			printf("\nBoarding Pass: Seat number %i in Economy\n\n", economyClass+1);
			++economyClass;
		
		}
		else if(selection == 2 && economyClass == 10){
			printf("Economy is Full. Type 1 to switch to First Class or next flight leaves in 3 hours\n");
		}
		else
			printf("Entry not valid\n");
	}
	//shows the user that the flight is booked
	printf("Currently the seats are assigned as follows from 1 -> 10 (0 is available and 1 is occupied)\n");
	for(int i = 0; i < 10; i++){
		printf("%i\t",seats[i] );
	}
	printf("\nThis flight is fully booked\n");
	
	return 0;
}


