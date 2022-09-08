// Faça um programa que leia 5 números e informe o maior número e a média desses números.

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        float num;
        int count = 5;
        float maiorNum = -1;
        float somaNum = 0;
        float media;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Insira um número:");
            num = input.nextFloat();

            if (num > maiorNum)
                maiorNum = num;

            somaNum += num;

            count -= 1;

        }while(count != 0);

        media = somaNum / 5;

        System.out.println("MAIOR NÚMERO = " + maiorNum );
        System.out.println("MÉDIA = " + media);

        input.close();
    }
}
