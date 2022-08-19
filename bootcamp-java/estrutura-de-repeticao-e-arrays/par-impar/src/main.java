// Faça um programa que peça N números inteiros. Calcule e mostre a
// quantidade de números pares e a quantidade de números impares.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int count;
        int num;
        int numPar = 0;
        int numImpar = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o número de termos:");
        count = input.nextInt();

        do {
            System.out.println("Insira um número:");
            num = input.nextInt();

            if (num % 2 == 0)
                numPar += 1;
            else
                numImpar += 1;

            count -= 1;

        } while (count > 0);

        System.out.println("Números ímpares = " + numImpar);
        System.out.println("Números pares = " + numPar);
    }
}
