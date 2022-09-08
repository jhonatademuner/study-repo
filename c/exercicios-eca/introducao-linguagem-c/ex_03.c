// Fazer um programa em C para ler uma temperatura dada na escala Fahrenheit
// e exibir o equivalente em Celsius.

#include <stdio.h>

int main(){

    float fahrenheit;
    float celsius;

    printf("Insira a temperatura em Fahrenheit a ser convertida: ");
    scanf("%f", &fahrenheit);

    celsius = (5 * (fahrenheit - 32)) / 9;

    printf("%.1fF equivale a %.1fC.", fahrenheit, celsius);

    return 0;
}