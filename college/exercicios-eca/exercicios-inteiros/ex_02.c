// Dado um número inteiro positivo n, calcular a soma dos n primeiros números inteiros positivos.

#include <stdio.h>

int main(){

    int num;
    int soma = 0;

    printf("Insira um numero inteiro: ");
    scanf("%d", &num);

    while (num > 0){
        soma += num;
        num -= 1;
    }

    printf("Soma de todos os numeros inteiros = %d", soma);

    return 0;
}