// Dados n e dois números inteiros positivos i e j diferentes de 0, imprimir
// em ordem crescente os n primeiros naturais que são múltiplos de i ou de j e ou de ambos.

#include<stdio.h>

int main(){

    int contador = 0;
    int i;
    int j;
    int num = 0;

    printf("Insira o numero de multiplos a serem imprimidas: ");
    scanf("%d", &contador);

    printf("Insira os multiplos permitidos: ");
    scanf("%d %d", &i, &j);

    while (contador > 0){
        num += 1;
        if ((num % i == 0) && (num % j == 0)){
            printf("%d, ", num);
            contador -= 1;
        }
    }

    return 0;
}