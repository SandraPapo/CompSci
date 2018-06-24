/*
Sandra Papo
104213584_TotalSales.c
Answer to Q1
*/

#include <stdio.h>


int main() {
    
  	
	double sales[3][7] = {0.0};
	double salesPersonTotal[3] = {0.0};
	double productTotal[7] = {0.0};
  	int salesPerson, product;
  	double dailyValueSold;
   
   	printf("Enter the salesperson, product, and total sales.\n");
   	printf("Enter Enter -1 for the salesperson to end input\n");
   	scanf("%d", &salesPerson);
   	while(salesPerson != -1){
	  	scanf("%d%lf", &product, &dailyValueSold);
	  	sales[salesPerson - 1][product - 1] += dailyValueSold;
   	 	scanf("%d", &salesPerson);
	}

	printf("The total sales for each salesperson\nare displayed at the end of each\n row, and the total sales for each product are displayed at the bottom\n of each column\n" );

	printf(" %7d%7d%7d%7d%7d%7d%7d\n",1,2,3,4,5,6,7);
	for(int i = 0; i < 3; ++i) {
	printf("%d", i + 1);
		for (int j = 0; j < 7; ++j) {
			printf("%7.2lf",sales[i][j]);
			salesPersonTotal[i] += sales[i][j];
			productTotal[j] += sales[i][j];
		}
	printf("%7.2lf\n", salesPersonTotal[i]);

	}
	printf(" ");
	for(int i = 0; i < 7; ++i)
		printf("%7.2lf",productTotal[i]);
	printf("\n");
	return 0;

}
/*
1 1 11
1 2 12
1 3 13
1 4 14 
1 5 15
1 6 16
1 7 17
2 1 21
2 2 22
2 3 23
2 4 24
2 5 25
2 6 26
2 7 27
3 1 31
3 5 35
3 7 37 
-1
*/












