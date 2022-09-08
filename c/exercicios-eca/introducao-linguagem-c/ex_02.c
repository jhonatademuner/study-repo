// Escreva um programa em C para ler dois números do tipo float e exibir a
// soma, subtração, multiplicação e divisão deles. OBS: Formate a saída para apenas duas
// casas decimais.

#include <stdio.h>

int main(){

    float num1;
    float num2;

    printf("Insira o primeiro numero da operacao: ");
    scanf("%f", &num1);

    printf("Insira o segundo numero da operacao: ");
    scanf("%f", &num2);

    printf("%.2f + %.2f = %.2f\n", num1, num2, (num1 + num2));
    printf("%.2f - %.2f = %.2f\n", num1, num2, (num1 - num2));
    printf("%.2f * %.2f = %.2f\n", num1, num2, (num1 * num2));
    printf("%.2f / %.2f = %.2f", num1, num2, (num1 / num2));

    return 0;
}