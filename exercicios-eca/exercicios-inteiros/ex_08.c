// Dado um inteiro não-negativo n, determinar n!

#include <stdio.h>

int main(){

    int num;
    int fatorial = 1;

    printf("Insira um numero: ");
    scanf("%d", &num);

    while(num > 0){
        fatorial *= num;
        num -= 1;
    }
    printf("Fatorial = %d", fatorial);

    return 0;
}