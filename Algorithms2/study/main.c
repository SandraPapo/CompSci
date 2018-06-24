/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>




int main() {
    FILE *ptr;
    ptr = fopen("cheese.dat", "w");
    fprintf(ptr, "cheese1\n");
    fprintf(ptr, "cheese2\n");
}
