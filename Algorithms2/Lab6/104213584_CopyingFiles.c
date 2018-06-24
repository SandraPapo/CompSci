//
// Created by Sandra Papo on 2017-11-30.
// Lab6
// Q3

#include <stdio.h>

int main(void){

    FILE *filePtr1, *filePtr2;
    char filename[100];
    char current;

    printf("Please enter a filename that you would like to copy:");
    scanf("%s", filename);

    if ((filePtr1 = fopen( filename, "r")) == NULL ) {
        puts( "File could not be opened");
    }

    printf("Please enter a filename that you would like to copy the file to:");
    scanf("%s", filename);

    if ((filePtr2 = fopen( filename, "w")) == NULL ) {
        puts("File could not be opened");
    }

    current = fgetc(filePtr1);
    while (current != EOF) {
        fputc(current, filePtr2);
        current = fgetc(filePtr1);
    }

    printf("%s\n", "Files successfully copied");

    fclose(filePtr1);
    fclose(filePtr2);

    return 0;
}