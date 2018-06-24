/*
Sandra Papo
104213584_RandomSentences.c
Answer to Q1
*/

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int main() {
	srand(time(NULL));


 	const char *article[6] = { "the", "a", "one", "some", "an", "any"};
    const char *noun[8] = { "boy", "man", "girl", "dog", "town", "computer", "woman", "car"};
    const char *verb[7] = { "drove","chatted", "jumped", "swum", "ran", "walked", "skipped"};
    const char *preposition[6] = { "to", "from", "over", "under", "at", "on"};
   	char sentence[100];
    for(int i = 0; i < 20; i++){
		strcat(sentence, article[rand() % 6]);
		strcat(sentence, " ");
		strcat(sentence, noun[rand() % 8]);
		strcat(sentence, " ");
		strcat(sentence, verb[rand() % 7]);
		strcat(sentence, " ");
		strcat(sentence, preposition[rand() % 6]);
		strcat(sentence, " ");
		strcat(sentence, article[rand() % 6]);
		strcat(sentence, " ");
		strcat(sentence, noun[rand() % 8]);
		strcat(sentence, ".");
		sentence[0] = toupper(sentence[0]);
		printf("%s\n", sentence );
		strcpy(sentence, "");
	}

	return 0;

}
