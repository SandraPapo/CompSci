/*
Sandra Papo
104213585
Question 1 (a)
*/

#include <stdio.h>
#include <string.h>


int main() {
    printf("Enter 0 on blank line to terminate\n");

    char myString[500] = "\0";
    char currentLine[80];
    while (currentLine[0] != '0') {
        fgets(currentLine, 80, stdin);
        currentLine[strlen(currentLine)] = '\0';
        strcat(myString,currentLine);
    }

    int alphabet[26] = {0};

    printf("%5s %5s\n", "char","#");

    for (int i = 0; i < strlen(myString); ++i) {
        int currentLetter = (int)myString[i] - (int)'a';
        if ((currentLetter >= 0 && currentLetter < 27) || ((currentLetter + ((int)'a' - (int)'A')) >= 0 && (currentLetter + ((int)'a' - (int)'A')) < 27)) {
            if((currentLetter >= 0 && currentLetter < 27)) {
                ++alphabet[currentLetter];
            }
            else {
                ++alphabet[currentLetter + ((int)'a' - (int)'A')];
            }

        }
    }

    for (int i = 0; i < 26; ++i) {
        printf("%5c %5d \n", (char)((int)'a' + i), alphabet[i]);
    }
    return 0;

}