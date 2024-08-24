// Gere e imprima uma matriz M 4x4 com valores aleatórios entre 0-9. Após isso determine
// o menor número da matriz e a sua posição(linha, coluna).

import java.util.Random;

public class main {

    public static void main(String[] args) {

        // Declaração das variáveis
        Random random = new Random();
        int[][] m = new int[4][4];
        int menorNumero = 10;
        int linha = 0;
        int coluna = 0;

        // Processamento
        for (int i = 0; i <= m.length - 1; i++) {
            for (int j = 0; j <= m[i].length - 1; j++){
                m[i][j] = random.nextInt(100);
                if (m[i][j] < menorNumero){
                    menorNumero = m[i][j];
                    linha = i;
                    coluna = j;
                }
            }
        }

        // Saída
        System.out.println("Matriz 4x4:");

        for (int i = 0; i <= m.length - 1; i++) {
            for (int j = 0; j <= m[i].length - 1; j++){
                System.out.print(m[i][j] + "  ");
            }
            System.out.print("\n");
        }

        System.out.println("Menor número da matriz = " + menorNumero + " (posição = " + (linha+1) + ", " + (coluna+1) + ")");
    }
}
