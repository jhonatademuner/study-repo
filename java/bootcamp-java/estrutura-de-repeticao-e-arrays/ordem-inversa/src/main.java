// Faça um Programa que leia um vetor de 5 números inteiros e mostre-os na ordem inversa.

public class main {

    public static void main(String[] args) {

        // Declaração de variáveis
        int[] vetor = {46, 26, 11, -2, -19};
        int count;

        // Inicialização de variáveis
        count = vetor.length -1;

        // Saída
        System.out.print("Vetor invertido:");

        // Processamento + Saída
        while (count >= 0) {
            System.out.print(" " + vetor[count]);
            count--;
        }
    }
}
