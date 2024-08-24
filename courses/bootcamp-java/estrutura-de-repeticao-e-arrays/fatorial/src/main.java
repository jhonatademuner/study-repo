// Faça um programa que calcule o fatorial de um número inteiro fornecido pelo usuário.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // Declaração de variáveis
        int num;
        int multiplicador;
        int resultado = 1;

        // Entrada
        Scanner input = new Scanner(System.in);

        System.out.print("Insira um número: ");
        num = input.nextInt();

        // Saída
        System.out.print(num + "!=");

        // Saída + Processamento
        for (multiplicador = num; multiplicador >= 2; multiplicador--){
            resultado *= multiplicador;
            System.out.print(multiplicador + ".");
        }

        System.out.print("1=" + resultado);
    }
}
