//
// Created by Sandra Papo on 2017-11-30.
// Lab6
// Q2

#include <stdio.h>

int main (void){
    int  numLines = 0;
    char numChar = 0;
    char current;
    FILE *filePtr;
    char fileName[150];

    printf("Please, enter a filename: ");
    scanf("%s", fileName);

    if ( ( filePtr = fopen( fileName, "r" ) ) == NULL ) {
        puts( "File could not be opened" );
    }
    else {
        while ((current = getc(filePtr)) != EOF){
            if (current != ' ' && current != '\n'){
                numChar++;
            }
            if (current == '\n'){
                numLines++;
            }
        }

        if (numChar > 0){
            numLines++;
        }
    }

    printf("There are %i characters in %s\n", numChar, fileName);
    printf("There are %i lines\n", numLines);

    fclose(filePtr);
    return 0;

}



