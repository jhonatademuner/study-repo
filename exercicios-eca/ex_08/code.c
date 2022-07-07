// Crie um programa em C que solicite ao usuário os valores de B, b e h, calcule e exibe a área do trapézio.

#include <stdio.h>

int main(){

    float baseMaior;
    float baseMenor;
    float altura;

    printf("Insira o valor da base maior: ");
    scanf("%f", &baseMaior);

    printf("Insira o valor da base menor: ");
    scanf("%f", &baseMenor);

    printf("Insira o valor da altura: ");
    scanf("%f", &altura);

    printf("Area do trapezio = %.2f", ((baseMaior * baseMenor)*altura)/2);

    return 0;
}