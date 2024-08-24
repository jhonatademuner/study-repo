// Construa um programa na linguagem C que calcule o novo salário de um funcionário.
// Considere que o funcionário deverá receber um reajuste de 15% caso seu salário seja
// menor que 500. Se o salário for maior ou igual a 500, mas menor ou igual a 1000, o
// reajuste deve ser de 10%. Caso o salário seja maior que 1000, o reajuste deve ser de 5%.

#include <stdio.h>

int main(){

    float salario;

    printf("Insira  o salario do funcionario: ");
    scanf("%f", &salario);

    if (salario < 500){
        salario *= 1.15;
        printf("\nREAJUSTE = 15%%\nSALARIO AJUSTADO = %.2f", salario);
    }
    else if (salario >= 500 && salario <= 1000){
        salario *= 1.10;
        printf("\nREAJUSTE = 10%%\nSALARIO AJUSTADO = %.2f", salario);
    }
    else {
        salario *= 1.05;
        printf("\nREAJUSTE = 5%%\nSALARIO AJUSTADO = %.2f", salario);
    }
    
    return 0;
}