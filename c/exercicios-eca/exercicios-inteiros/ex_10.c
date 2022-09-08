// Dizemos que um número natural é triangular se ele é produto de três números naturais consecutivos.

#include <stdio.h>

int main(){

    int num;
    int numTeste = 0;

    printf("Insira um numero: ");
    scanf("%d", &num);

    while(numTeste < (num / 3)){
        if(num == (numTeste * (numTeste + 1) * (numTeste + 2))){
            printf("O numero inserido e triangular.");
        }
        numTeste += 1;
    }

    return 0;
}