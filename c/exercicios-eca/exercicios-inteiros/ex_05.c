// Uma loja de discos anota diariamente durante o mês de março a
// quantidade de discos vendidos. Determinar em que dia desse mês ocorreu
// a maior venda e qual foi a quantidade de discos vendida nesse dia.

#include <stdio.h>

int main(){

    int dia;
    int diaMaisVendas;
    int discos;
    int maisVendas = 0;

    printf("Insira o dia: ");

    while (dia > 0){
        printf("Insira quantos discos foram vendidos: ");
        scanf("%d", &discos);
        if (discos > maisVendas){
            maisVendas = discos;
            diaMaisVendas = dia;
        }
        printf("Insira o dia: ");
        scanf("%d", &dia);
    }
    printf("Voce vendeu %d discos no dia %d. E esse foi seu dia com mais vendas nesse mes.", maisVendas, diaMaisVendas);
    return 0;
}