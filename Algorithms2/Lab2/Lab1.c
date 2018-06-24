/*
Author: Sandra Papo
Date: 012/10/2017

The answer to number 5
*/

#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#include<time.h>

int main(void){

	srand(time(NULL));
	//printf("%d\n", a);
	int t[2][5] = {0};
		printf("\t1\t2\t3\t4\t5");
	for (int i = 0; i < 2; ++i)
	{
		printf("\n%i", i + 1);
		for (int j = 0; j <5; ++j)
		{
			printf("\t%i ",t[i][j] );
		}
		/* code */
	}

	/*float arr[12] = {0};
	for (size_t i = 0; i < 12; i++){
		scanf("%f",&arr[i]);
	}*/
	/*
	for(int i = 0 ; i < 15; i++){
		//srand(time(NULL));
		int a = (rand()%5+1)*4 + 2;	
		printf("%d\n", a);
		
	}

	for(int i = 0 ; i < 10000000; i++){
		//srand(time(NULL));
		int a = rand()%10;
		if(a < 0 || a > 9){
			printf("NOPE2 %d\n", a);
			return 0;
		}
	}

	for(int i = 0 ; i < 10000000; i++){
		//srand(time(NULL));
		int a = rand()%113+1000;
		if(a < 1000 || a > 1112){
			printf("NOPE3 %d\n", a);
			return 0;
		}
	}

	for(int i = 0 ; i < 10000000; i++){
		//srand(time(NULL));
		int a = rand()%3-1;
		if(a < -1 || a > 1){
			printf("NOPE4 %d\n", a);
			return 0;
		}
	}

	for(int i = 0 ; i < 10000000; i++){
		//srand(time(NULL));
		int a = rand()%15-3;
		if(a < -3 || a > 11){
			printf("NOPE5 %d\n", a);
			return 0;
		}
	}
*/

	printf("We Gucci\n");

	return 0;
}
