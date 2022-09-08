// Calcule o valor final de um empréstimo, a partir do valor
// solicitado. Taxas e parcelas influenciam. Defina arbitrariamente
// as faixas que influenciam nos valores.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        float emprestimo;
        float taxa;
        int parcelas;
        float total;

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o valor do empréstimo:");
        emprestimo = input.nextFloat();

        System.out.println("Insira a taxa mensal:");
        taxa = input.nextFloat();

        System.out.println("Insira o número de parcelas: ");
        parcelas = input.nextInt();

        total = emprestimo * (1 + taxa) * parcelas;

        System.out.println("Você irá pagar um total de R$ %.2f" + total + ".");

        input.close();
    }
}
