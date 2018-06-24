/*
Sandra Papo
104213585
Question 3
*/


#include <stdio.h>

int packCharacters (char char1, char char2);
void printBits( unsigned int num );
void unpackCharacters( unsigned int value );

int main() {
    char first;
    char second;
    printf("%s", "Enter char 1 & char 2 (eg. 's d ')\n");
    scanf(" %c %c", &first, &second);


    printBits((unsigned int)first);
    printBits((unsigned int)second);
    
    unpackCharacters(packCharacters(first, second));
    return 0;
}
void unpackCharacters( unsigned int value ) {

    unsigned int int1 = value;
    unsigned int int2 = value;
    int1 &= 65280;
    int1 >>= 8;
    char unpacked1 = int1;
    int2 &= 255;
    char unpacked2 = int2;

    printf( "\nchar 1 after unpacking is: %c\n\n", unpacked1 );
    printf( "\nchar 2 after unpacking is: %c\n", unpacked2 );

}


int packCharacters (char char1, char char2) {
    unsigned int int1 = (unsigned int)char1;
    int1 <<= 8;
    unsigned int int2 = (unsigned int)char2;
    int1 = int1|int2;

    printf("result is: \n");
    printBits(int1);
    return int1;
}


void printBits( unsigned int num ) {


    unsigned int displayMask = 1 << 31; printf( "\n%10u = ",num );

    for( int i = 1 ; i <= 32 ; ++i ) {
        printf("%c", num & displayMask ? '1' : '0');
        num <<= 1;
        if ( i % 8 == 0 ) {
            printf("%c", ' ');
        }
    }
    printf("%c", '\n');


}