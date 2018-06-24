#include <stdio.h>
#include <ctype.h>

//toupper()

void uppercase(char *ptr);

int main() {
	char string[] = "HeLlO bIg BoY";
	char *sPtr;
	sPtr = string;
	printf("%s\n", string);
	uppercase(sPtr);
	printf("%s\n", string);
	return 0;
}

void uppercase(char *ptr) {
	while(*ptr != '\0') {
		*ptr = toupper(*ptr);
		ptr++;
	}	
}

