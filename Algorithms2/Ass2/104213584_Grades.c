/*
Sandra Papo
104213584_Grades.c
Answer to Q3
*/


#include <stdio.h>
#include <stdlib.h>
#define STUDENTS 3
#define EXAMS 4

void minimum( const int grades[][ EXAMS ], size_t pupils, size_t tests );
void maximum( const int grades[][ EXAMS ], size_t pupils, size_t tests );
void average( const int grades[][EXAMS ], size_t pupils, size_t tests );
void printArray( const int grades[][ EXAMS ], size_t pupils, size_t tests );


int main(void) {

	size_t student; 
	int choice = 0;

	const int studentGrades[STUDENTS][EXAMS] = { { 77, 68, 86, 73 }, { 96, 87, 89, 78 }, { 70, 90, 86, 81 } };
	printf("test for average");
	average( studentGrades, STUDENTS, EXAMS);
	puts( "The array is:" );
	printArray( studentGrades, STUDENTS, EXAMS );

	void (*processGrades[4])( const int[][EXAMS], size_t, size_t ) = { printArray, minimum, maximum, average};

	printf("Enter a choice:\n\t0\tPrint the array of grades\n\t1\tFind the minimum grade\n\t2\tFind the maximum grade\n");
	printf("\t3\tPrint the average on all tests for each student\n\t4\tEnd program\n");
	scanf("%d", &choice);
	printf("\n");

	while (choice >= 0 && choice < 4){
		(*processGrades[choice])(studentGrades, STUDENTS, EXAMS);
		printf("\n\n\n");
		printf("Enter a choice:\n\t0\tPrint the array of grades\n\t1\tFind the minimum grade\n\t2\tFind the maximum grade\n");
		printf("\t3\tPrint the average on all tests for each student\n\t4\tEnd program\n");
		scanf("%d", &choice);
		printf("\n");
	}
	printf("Program complete\n");

	return 0;

}

void minimum( const int grades[][ EXAMS ], size_t pupils, size_t tests ) {

	int min = grades[0][0]; 

	for(int i = 0; i < pupils ; i++){
		for ( int j = 0; j < tests; j++ ) {
			if ( grades[ i ][ j ] < min ) {
				min = grades[i][j];      
			}

		}
	}
	printf("Lowest grade: %d: ", min);
}


void maximum( const int grades[][ EXAMS ], size_t pupils, size_t tests ) {
	int max = grades[0][0]; 
	for ( int i = 0; i < pupils; i++ ) {
		for ( int j = 0 ; j < tests; j++){
			if (grades[i][j] > max){
				max = grades[i][j];
        	}
		}
   }
 printf("Highest grade: %d: ",max);
}

void average( const int grades[][EXAMS ], size_t pupils, size_t tests ) {
	int total;
	for ( int i = 0; i < pupils; i++) {
		total = 0;
		for ( int j = 0; j < tests; ++j ) {
			total += grades[i][j];
		}
		printf ("The average for student: %i is %.2f\n", i, (double) total/tests); // average
	} 
}


void printArray(const int grades[][ EXAMS ], size_t pupils, size_t tests ) {

  printf( "%s", "                  [0] [1] [2] [3]" );


  for ( int i = 0; i < pupils; i++ ) { 
  	printf( "\nstudentGrades[%i] ", i );

  	for(int j = 0; j < tests; j++){
  		printf( "%-5d", grades[ i ][ j ] );
    } 
   } 
} 






