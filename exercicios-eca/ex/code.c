// Um motorista anota a marcação do odômetro do seu veículo antes e após
// uma viagem, bem como o número de litros de combustível gastos. Faça um programa em
// C que solicite ao usuário os 3 dados acima, o preço do litro de combustível, a capacidade
// do tanque e mostre:
// a) Quilometragem rodada.
// b) Quantos quilômetros por litro faz o veículo
// c) Autonomia do veículo.
// d) Custo da viagem.*

#include <stdio.h>
#include <stdlib.h>

int main () {

    double kmInicio, kmFim, litrosGastos, precoLitro, tanque;
    double kmRodados, kmLitro, autonomia, custoViagem;

    scanf ("%f", &kmInicio);
    scanf ("%f", &kmFim);
    scanf ("%f", &litrosGastos);
    scanf ("%f", &precoLitro);
    scanf ("%f", &tanque);

    kmRodados = kmFim - kmInicio;
    kmLitro = kmRodados / litrosGastos;
    autonomia = tanque * kmLitro;
    custoViagem = litrosGastos * precoLitro;

    printf ("Quilometros rodados = %.2f\n", kmRodados);
    printf ("Km/L = %.2f\n", kmLitro);
    printf ("Autonomia = %.2f\n", autonomia);
    printf ("Custo da viagem = %.2f\n", custoViagem);

    return 0;
}