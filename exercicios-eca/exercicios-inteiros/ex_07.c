// Dados n e uma seqüência de n números inteiros, determinar a soma dos números pares.

#include <stdio.h>

int main(){

    int num = 1;
    int somaPares = 0;

    while (num != 0){
        printf("Insira um numero: ");
        scanf("%d", &num);
        if (num % 2 == 0){
            somaPares += num;
        }
    }
    printf("Soma dos numeros pares = %d", somaPares);

    return 0;
}