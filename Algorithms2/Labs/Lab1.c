/*
Author: Sandra Papo
Date: 05/10/2017

The answer to number 5
*/

#include<stdio.h>
int main(void){
	int sum = 0;
	for(int i = 1; i<=10;i++){
		int squared = i*i;
		sum += squared;
		printf("%d\n", squared);
	}
	printf("The total is %d\n", sum);
	return 0;
}
