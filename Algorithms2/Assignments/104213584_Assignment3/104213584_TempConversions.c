/*
Sandra Papo
104213585
Question 2
*/

#include <stdio.h>

int main() {

    int fahrenheit;
    float celsius;

    for (fahrenheit = 0; fahrenheit <= 212; fahrenheit++) {
        celsius = 5.0/9.0 *(fahrenheit - 32);
        printf("%10d%10.3f\n", fahrenheit, celsius);
    }

    if (celsius <= 0 && celsius <= 100) {
        printf("%+10.3f", celsius);
    }
    return 0;
}
