/*
Sandra Papo
104213584_ChequeAmount.c
Answer to Q2
*/

#include <stdio.h> 
#include <stdlib.h> 

void printHundreds(int hundreds);

const char *ones[] = {"Zero", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
const char *teens[] = {"Ten", "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
const char *tens[] = {"Error", "Error","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
const char *powers[] = {"Hundred", "Thousand", "Million", "Billion"}; 

int main() {

	double chequeAmount;
	printf("Enter the cheque amount:  ");
	scanf("%lf", &chequeAmount);
	printf("The check amount in words is: \n");

	int number = (int) chequeAmount;
	int cents = (int)(chequeAmount*100.0) % 100;

	if((int)(number / 1000000000) > 0){
		printHundreds((int)((number / 1000000000)));
		printf("%s ", powers[3]);
		number = number % 1000000000;
	}

	if((int)(number / 1000000) > 0){
		printHundreds((int)((number / 1000000)));
		printf("%s ", powers[2]);
		number = number % 1000000;
	}

	if((int)(number / 1000) > 0){
		printHundreds((int)((number / 1000)));
		printf("%s ", powers[1]);
		number = number % 1000;
	}
	if(number > 0){
		printHundreds((int)number );
		number = number % 100;
	}

	printf("Dollars and %d/100 Cents\n", cents);


	return 0;
}

void printHundreds(int hundreds) {
	
	if(hundreds >= 100) {
		printf("%s %s ", ones[(int)(hundreds/100)], powers[0]);
		hundreds = hundreds % 100;
	}
	if (hundreds >= 20 ) {
		printf("%s-", tens[(int)(hundreds/10)]);
		hundreds = hundreds % 10;
	}
	else if ( hundreds >= 10) {
		printf("%s ", teens[(int)(hundreds-10)]);
		hundreds = 0;
	}

	if(hundreds > 0) {
		printf("%s ", ones[(int)hundreds]);
	}
}






