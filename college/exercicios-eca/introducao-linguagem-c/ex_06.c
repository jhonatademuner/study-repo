// Escreva um programa em C que leia os valores da base e altura de um triângulo e calcula a sua área.

#include <stdio.h>
#include <math.h>

int main(){

    float base;
    float altura;

    printf("Insira a o valor da base do triangulo: ");
    scanf("%f", &base);

    printf("Insira a o valor da altura do triangulo: ");
    scanf("%f", &altura);

    printf("Area do triangulo = %f", ((base * altura) / 2));

    return 0;
}