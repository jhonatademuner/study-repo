// Dizemos que um inteiro positivo n é perfeito se for igual à soma de seus
// divisores positivos diferentes de n. Dado um inteiro positivo n, verificar se n é perfeito.

#include <stdio.h>

int main(){

    int num;
    int divisor = 1;
    int soma = 0;

    printf("Insira um numero inteiro: ");
    scanf("%d", &num);

    while(divisor <= (num/2)){
        if(num % divisor == 0){
            soma += divisor;
        }
        divisor += 1;
    }

    if (soma == num){
        printf("O numero inserido e perfeito.");
    } else {printf("O numero inserido nao e perfeito.");}

    return 0;
}