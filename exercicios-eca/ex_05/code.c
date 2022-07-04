// Escreva um programa em C que leia o raio de um círculo e calcula a sua área. 

#include <stdio.h>
#include <math.h>

int main(){

    float raio;

    printf("Insira o raio do circulo: ");
    scanf("%f", &raio);

    printf("Area do circulo = %.2f", M_PI * pow(raio, 2));

    return 0;
}