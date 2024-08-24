//Desenvolva um gerador de tabuada, capaz de gerar a tabuada de qualquer número inteiro
// entre 1 a 10. O usuário deve informar de qual numero ele deseja ver a tabuada.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // Declaração de variáveis
        int num;
        int multiplicador;
        int resultado;

        // Entrada
        Scanner input = new Scanner(System.in);

        System.out.print("Insira um número: ");
        num = input.nextInt();

        // Saída
        System.out.println("Tabuada de " + num + ":");

        // Processamento + Saída
        for (multiplicador = 1; multiplicador <= 10; multiplicador += 1) {
            resultado = num * multiplicador;
            System.out.println(num + " X " + multiplicador + " = " + (resultado));
        }

        input.close();
    }
}
