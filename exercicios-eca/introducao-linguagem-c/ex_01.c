// Implemente um programa em C para ler um número inteiro e exibir o seu dobro e o seu triplo.

#include <stdio.h>

int main(){

    int num;
    
    printf("Insira um numero: ");
    scanf("%d", &num);

    printf("%d * 2 = %d\n", num, (num * 2) );
    printf("%d * 3 = %d", num, (num * 3) );

    return 0;
}