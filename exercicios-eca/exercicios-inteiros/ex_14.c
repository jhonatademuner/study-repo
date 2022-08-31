// Um matemático italiano da idade média conseguiu modelar o ritmo de crescimento
// da população de coelhos (1) através de uma seqüência de números naturais que passou
// a ser conhecida como seqüência de Fibonacci (2). Faça um programa que, dado n, calcula Fn

#include <stdio.h>

int main(){

    int contador;
    int nTermo = 1;
    int f1 = 0;
    int f2 = 1;

    printf("Insira o N termo que voce quer: ");
    scanf("%d", &contador);

    while(contador > 1){
        nTermo = f2 + f1;
        f1 = f2;
        f2 = nTermo;
        contador -= 1;
    }

    printf("%d", nTermo);

    return 0;
}