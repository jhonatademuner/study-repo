// Dados dois números inteiros positivos, determinar o máximo divisor comum
// entre eles usando o algoritmo de Euclides.

#include <stdio.h>

int main(){

    int num1;
    int num2;
    int maiorNum;
    int menorNum;
    int dividendo;
    int divisor;
    int resto;
    int mdc;

    printf("Insira 2 numeros inteiros positivos: ");
    scanf("%d %d", &num1, &num2);

    if (num1 > num2){
        maiorNum = num1;
        menorNum = num2;
    } else {
        maiorNum = num2;
        menorNum = num1;
    }

    dividendo = maiorNum;
    divisor = menorNum;
    resto = dividendo % divisor;
    
    while(resto != 0){
        dividendo = divisor;
        divisor = resto;
        resto = dividendo % divisor;
    }

    mdc = divisor;

    printf("MDC = %d", mdc);

    return 0;
}