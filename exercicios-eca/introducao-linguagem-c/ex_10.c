// Escreva um programa na linguagem C que informe se um dado ano é ou não
// bissexto. Obs.: um ano é bissexto se ele for divisível por 400 ou se ele for divisível por 4
// e não por 100. Solicite ao usuário o ano que ele deseja saber se é bissexto.

#include <stdio.h>

int main(){

    int ano;

    printf("Insira  o ano que voce deseja saber se e bissesexto: ");
    scanf("%d", &ano);

    if (ano > 2022){
        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)){
            printf("O ano que voce inseriu sera um ano bissexto.");
        } else {
            printf("O ano que voce inseriu nao sera um ano bissexto.");
        }
    } else {
        if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)){
            printf("O ano que voce inseriu foi um ano bissexto.");
        } else {
            printf("O ano que voce inseriu nao foi um ano bissexto.");
        }
    }

    return 0;
}