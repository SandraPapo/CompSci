/*
Name: Sandra Papo
SN: 104213584
Date: October 19th, 2017
104213594_TowerofHannoi.c
this is the solution to the first question in the assignment
 */ 
#include <stdio.h> 

//recursive function
void Hanoi( int n, int source, int destination, int intermediate) { 
	if (n == 1){
		printf("%i --> %i\n", source, destination);
	}
	else {
		Hanoi(n-1, source, intermediate, destination);
		printf("%i --> %i \n", source, destination);
		Hanoi(n-1, intermediate, destination, source);
	}
} 
//main code
int main( void ) { 
	int n;
	//getting user input
	printf("Enter the starting number of disks: ");
	scanf("%i", &n);
	//Calling the recursive function
	Hanoi(n,1,3,2);
	return 0;
}


