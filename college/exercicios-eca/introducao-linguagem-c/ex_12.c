// Faça um programa na linguagem C que verifique se um funcionário já pode
// se aposentar, a partir da leitura do seu ano de nascimento e do tempo de serviço.
// Ele poderá se aposentar se pelo menos uma das condições abaixo for verdadeira:
// Ter no mínimo 65 anos de idade.
// Ter trabalhado, no mínimo, 30 anos.
// Ter no mínimo 60 anos de idade e ter trabalhado no mínimo 25 anos

#include <stdio.h>

int main(){

    int anoNascimento;
    int tempoServico;
    int idade;

    printf("Insira o ano de nascimento do funcionario: ");
    scanf("%d", &anoNascimento);

    printf("Insira  o tempo de servico do funcionario: ");
    scanf("%d", &tempoServico);

    idade = 2022 - anoNascimento;

    if (idade >= 65){
        printf("O funcionario pode se aposentar.");
    }
    else if (tempoServico >= 30){
        printf("O funcionario pode se aposentar.");
    }
    else if ((idade >= 60) && (tempoServico >= 25)){
         printf("O funcionario pode se aposentar.");
    }
    else{
         printf("O funcionario nao pode se aposentar.");
    }

    return 0;
}