#include <stdio.h>

int main(){

    float horasTrabalhadas;
    float valorHora;
    float salarioBruto;
    float salarioBruto_inss;
    float impostoRenda;
    float salarioLiquido;

    printf("Insira as horas trabalhadas pelo empregado: ");
    scanf("%f", &horasTrabalhadas);

    printf("Insira o valor da hora trabalhada: ");
    scanf("%f", &valorHora);

    salarioBruto = horasTrabalhadas * valorHora;
    salarioBruto_inss = (salarioBruto / 100) * 89;

    if (salarioBruto_inss <= 1499.15){
        impostoRenda = 0;
    }
    else if (salarioBruto_inss >= 1499.16 && salarioBruto_inss <= 2246.75){
        impostoRenda = 0.075 * salarioBruto_inss - 112.43;
    }
    else if (salarioBruto_inss >= 2246.76 && salarioBruto_inss <= 2995.70){
        impostoRenda = 0.15 * salarioBruto_inss - 280.94;
    }
    else if (salarioBruto_inss >= 2995.71 && salarioBruto_inss <= 3743.19){
        impostoRenda = 0.225 * salarioBruto_inss - 505.62;
    }
    else{
        impostoRenda = 0.275 * salarioBruto_inss - 692.78;
    }

    salarioLiquido = salarioBruto_inss - impostoRenda;

    printf("SALARIO LIQUIDO = %.2f", salarioLiquido);
    printf("\n%f", salarioBruto);
    printf("\n%f", salarioBruto_inss);
    printf("\n%f", impostoRenda);

    return 0;
}