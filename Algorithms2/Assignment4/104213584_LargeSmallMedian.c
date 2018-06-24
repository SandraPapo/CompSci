/*
Sandra Papo
104213585
Question 1 Assignment 4
*/

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    FILE *cfPtr;

    if (argc != 2) {
        printf("Arguments invalid\n");
        exit(EXIT_FAILURE);
    }
    cfPtr = fopen(argv[1], "r");

    if (cfPtr == NULL ) {
        puts( "File could not be opened: " );
        exit(EXIT_FAILURE);
    }

    int numbers[1000];
    int endIndex = -1;
    int currentNum;

    while (!feof(cfPtr)) {
       	fscanf(cfPtr, "%d", &currentNum);
        endIndex++;
        numbers[endIndex] = currentNum;    
    }

    int temp;

    for (int i = 0; i < endIndex; i++){
 		 for (int j = 0; j < endIndex; j++){
 			if (numbers[j] > numbers[j+1]){
 				temp = numbers[j];
 				numbers[j] = numbers[j+1];
 				numbers[j+1] = temp;
 			}
 		}
	}

    int max = numbers[endIndex];
    int min = numbers[0];
    int median;
    if ((endIndex + 1) % 2 == 0) {
    	median = (int)((numbers[(int)((endIndex)/2)] + numbers[(int)((endIndex)/2)+1])/2);
    }
    else
    	median = numbers[(int)((endIndex)/2)];

    printf("the min is %d the max is %d and the median is %d \n", min, max, median);
    return 0;
}

