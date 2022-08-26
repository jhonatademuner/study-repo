// Escreva um programa em C que solicite 2 números x e y e imprima:
// A soma dos números (x + y);
// O produto do primeiro número pelo quadrado do segundo (x * y^2);
// O primeiro número elevado a quarta (x^4);
// A raiz quadrada da soma dos quadrados ( √(𝑥^2 + 𝑦^2) );
// O seno da diferença do primeiro número pelo segundo (seno (x – y));
// O módulo do primeiro número.

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    float numx;
    float numy;

    printf("Insira o primeiro numero da operacao: ");
    scanf("%f", &numx);

    printf("Insira o segundo numero da operacao: ");
    scanf("%f", &numy);

    printf("\nSoma dos numeros = %.2f\n", (numx + numy));
    printf("Produto do primeiro numero pelo quadrado do segundo = %.2f\n", (numx * pow(numy, 2)));
    printf("Primeiro numero elevado a quarta = %.2f\n", pow(numx, 4));
    printf("Raiz quadrada da soma dos quadrados = %.2f\n", (pow(pow(numx, 2) + pow(numy, 2), 0.5)));
    printf("Seno da diferenca do primeiro numero pelo segundo = %.2f\n", sin(numx - numy));
    printf("Modulo do primeiro numero = %.2f", fabs(numx));

    return 0;
}