// Desenvolva um programa em C que leia as três notas de um aluno, calcule e exiba:
// A media aritmetica;
// A media ponderada usando os pesos 3, 3 e 4 respectivamente;
// A media harmonica.

#include <stdio.h>

int main(){

    float nota1;
    float nota2;
    float nota3;

    printf("Insira a primeira nota: ");
    scanf("%f", &nota1);

    printf("Insira a segunda nota: ");
    scanf("%f", &nota2);

    printf("Insira a terceira nota: ");
    scanf("%f", &nota3);

    printf("Media aritmetica = %.2f\n", (nota1 + nota2 + nota3)/3);
    printf("Media Ponderada = %.2f\n", (nota1 * 3 + nota2 * 3 + nota3 * 4)/10);
    printf("Media harmonica = %.2f", 3 / ( 1 / nota1 + 1 / nota2 + 1 / nota3));

    return 0;
}