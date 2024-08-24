// Faça um Programa que leia um vetor de 6 caracteres, e diga quantas consoantes foram
// lidas. Imprima as consoantes.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // Declaração de variáveis
        String[] vetor = new String[6];
        String letra;
        int consoantes = 0;

        Scanner input = new Scanner(System.in);

        // Entrada + Processamento
        for (int i = 0; i <= vetor.length - 1; i++) {
            letra = input.next();
            if (!(letra.equalsIgnoreCase("a") |
            letra.equalsIgnoreCase("e") |
            letra.equalsIgnoreCase("i") |
            letra.equalsIgnoreCase("o") |
            letra.equalsIgnoreCase("u"))){
                consoantes += 1;
                vetor[i] = letra;
            }
        }

        // Saída
        System.out.println("Você inseriu " + consoantes + " consoantes.");
        System.out.print("Você inseriu as seguintes consoantes:");

        for (int i = 0; i <= vetor.length -1; i++){
            if (vetor[i] != null) {
                System.out.print(" " + vetor[i]);
            }
        }

        System.out.println(".");

        input.close();
    }
}
