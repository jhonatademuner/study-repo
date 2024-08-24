// Dados o número n de alunos de uma turma de Introdução aos Autômatos a
// Pilha (MAC 414) e suas notas da primeira prova, determinar a maior e a
// menor nota obtidas por essa turma (Nota máxima = 100 e nota mínima = 0).

#include <stdio.h>

int main(){

    int numAlunos;
    int nota;
    int maiorNota = -1;
    int menorNota = 101;

    printf("Insira o numero de alunos: ");
    scanf("%d", &numAlunos);

    while (numAlunos > 0){
        printf("Insira a nota do aluno: ");
        scanf("%d", &nota);
        if(nota > maiorNota){
            maiorNota = nota;
        } else if(nota < menorNota){
            menorNota = nota;
        }
        numAlunos -= 1;
    }

    printf("Maior nota = %d\t Menor nota = %d", maiorNota, menorNota);

    return 0;
}