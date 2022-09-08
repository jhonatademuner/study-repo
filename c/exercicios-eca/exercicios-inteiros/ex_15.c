// Dizemos que um número i é congruente módulo m a j se i % m = j % m.
// Exemplo: 35 é congruente módulo 4 a 39, pois 35 % 4 = 3 = 39 % 4.
// Dados inteiros positivos n, j e m, imprimir os n primeiros naturais congruentes a j módulo m.

#include <stdio.h>

int main(){

    int i;
    int m;
    int j;

    printf("Insira o i, m e j: ");
    scanf("%d %d %d", &i, &m, &j);

    if((i % m == j % m)){
        printf("%d e congruente modulo %d a %d.", i, m, j);
    } else{
        printf("%d nao e congruente modulo %d a %d.", i, m, j);
    }

    return 0;
}