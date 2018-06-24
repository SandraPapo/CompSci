/*
Sandra Papo
104213585
Question 1 (c)
*/


#include <stdio.h>
#include <string.h>


int main() {

    printf("Enter 0 on blank line to terminate\n");

    char myString[500] = "\0";
    char currentLine[80];
   char allWords[500][25];
    int numWords = 0;

    int numWordLength[25] = {0};

    while (currentLine[0] != '0') {
        fgets(currentLine, 80, stdin);
        currentLine[strlen(currentLine)] = '\0';
        strcat(myString," ");
        strcat(myString,currentLine);
    }

    char *token;

    token = strtok(myString, " ");

    // walk through other tokens
    while( token != NULL ) {

        char word[25] = "\0";

        for (int i = 0; i < strlen(token); ++i) {

            int currentLetter = (int)token[i] - (int)'a';
            int tokenArr[2];

            if ((currentLetter >= 0 && currentLetter < 27) || ((currentLetter + ((int)'a' - (int)'A')) >= 0 && (currentLetter + ((int)'a' - (int)'A')) < 27)) {
                if((currentLetter >= 0 && currentLetter < 27)) {
                    tokenArr[0] = token[i];
                    tokenArr[1] = '\0';
                    strcat(word, tokenArr);

                }
                else {
                    tokenArr[0] = (char)((int)token[i] + ((int)'a' - (int)'A'));
                    tokenArr[1] = '\0';
                    strcat(word,tokenArr);
                }

            }

        }
        if (strlen(word) > 0) {
            strcpy(allWords[numWords], word);
            numWords++;
        }

        token = strtok(NULL, " ");

    }

    for(int i = 0; i < numWords; i++) {
        int count = 0;
        for(int j = 0; j < numWords; j++) {
            if( strcmp(allWords[i], allWords[j]) == 0) {
                if (i != j)
                    strcpy(allWords[j], "");
                count++;
            }
        }
        if( strcmp(allWords[i], "") != 0)
            printf("contains the word %s %d times\n", allWords[i], count);
    }


    return 0;

}