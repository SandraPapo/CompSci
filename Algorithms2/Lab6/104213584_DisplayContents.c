//
// Created by Sandra Papo on 2017-11-30.
// Lab6
// Q1

#include <stdio.h>

int main(){
    char fileName[100] = "content.txt";
    FILE *filePointer = fopen(fileName, "r");
    int line = 0;
    int character;
    if(filePointer == NULL){
        printf("File doesn't exist\n");
        return 0;
    }
    while((character = fgetc(filePointer)) != EOF){
        putchar(character);
        if(character == '\n'){
            line += 1;
            if(line == 10){
                line = 0;
                printf("Press return to continue, or 'q' to quit: ");
                if(getchar() == 'q')
                    break;
            }
        }
    }
    fclose(filePointer);
    return 0;
}