// Faça um programa que peça uma nota, entre zero e dez.
// Mostre uma mensagem caso o valor seja inválido e continue
// pedindo até que o usuário informe um valor válido.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        float nota;

        Scanner input = new Scanner(System.in);

        System.out.println("Insira uma nota de 0 a 10: ");
        nota = input.nextFloat();

        while ((nota < 0) || (nota > 10)) {
            System.out.println("Nota inválida, tente novamente: ");
            nota = input.nextFloat();
        }

        System.out.println("Valor válido, nota = " + nota);

        input.close();
    }
}
