/*
Sandra Papo
104213585
Question 1 (b)
*/

#include <stdio.h>
#include <string.h>


int main() {

    printf("Enter 0 on blank line to terminate\n");

    char myString[500] = "\0";
    char currentLine[80];

    int numWordLength[25] = {0};

    while (currentLine[0] != '0') {
        fgets(currentLine, 80, stdin);
        currentLine[strlen(currentLine)] = '\0';
        strcat(myString," ");
        strcat(myString,currentLine);
    }

    char *token;

    // get the first token
    token = strtok(myString, " ");
    //strcat(token, " ");

    // walk through other tokens
    while( token != NULL ) {

        int tokenLength = 0;


        for (int i = 0; i < strlen(token); ++i) {

            int currentLetter = (int)token[i] - (int)'a';

            if ((currentLetter >= 0 && currentLetter < 27) || ((currentLetter + ((int)'a' - (int)'A')) >= 0 && (currentLetter + ((int)'a' - (int)'A')) < 27)) {
                tokenLength++;
            }

        }


        numWordLength[tokenLength]++;

        token = strtok(NULL, " ");
        //strcat(token, " ");


    }

    printf("%10s %10s\n", "word length","occurrences");

    for (int i = 1; i < 25; ++i) {
        printf("%10d  %10d \n", i ,numWordLength[i]);
    }

    return 0;

}