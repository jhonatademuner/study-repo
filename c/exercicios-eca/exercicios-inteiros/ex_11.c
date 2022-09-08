// Dado um inteiro positivo n, verificar se n é primo.

#include <stdio.h>

int main(){

    int num;
    int divisor = 2;
    int possiveisDivisores = 0;

    printf("Insira um numero inteiro: ");
    scanf("%d", &num);

    while(divisor <= (num/2)){
        if(num % divisor == 0){
            possiveisDivisores += 1;
        }
        divisor += 1;
    }

    if (possiveisDivisores == 0){
        printf("O numero inserido e primo.");
    } else {printf("O numero inserido nao e primo.");}

    return 0;
}