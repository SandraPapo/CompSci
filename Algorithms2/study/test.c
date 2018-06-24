/* Fig. 7.4: fig07_04.c
 Using the & and * operators */
#include<stdio.h>

int main(void){
	int a;
	int *aPtr;

	a = 7;
	aPtr = &a;

	printf("The address of a is %p\n The value of aPtr is %p;", &a, aPtr);

	printf( "\nThe value of a is %d\nThe value of *aPtr is %d", a, *aPtr);
}