// Faça um Programa que leia 20 números inteiros aleatórios (entre 0 e 100) armazene-os num vetor.
// Ao final, mostre os números e seus sucessores.
import java.util.Random;

public class main {

    public static void main(String[] args) {

        // Declaração de variáveis
        Random random = new Random();
        int[] num = new int [20];
        int[] sucessor = new int [20];

        System.out.println("Esse programa irá exibir 20 úmeros aleatorios de 0 a 100 e seus sucessores.");

        // Processamento + Saída
        for (int i = 0; i <= num.length - 1; i++){
            num[i] = random.nextInt(100);
            sucessor[i] = num[i] + 1;
            System.out.println(num[i] + " | " + sucessor[i]);
        }
    }
}
