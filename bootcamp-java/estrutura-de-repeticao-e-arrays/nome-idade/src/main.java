// Faça um programa que leia conjuntos de dois valores, o
// primeiro representando o nome do aluno e o segundo representando
// a sua idade.Pare o programa inserindo o valor 0 no campo nome.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        String nome;
        int idade;

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o nome do aluno: ");
        nome = input.next();

        while (!nome.equals("0")) {

            System.out.println("Insira a idade do aluno: ");
            idade = input.nextInt();

            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);

            System.out.println("Insira o nome do aluno: ");
            nome = input.next();

        }

        input.close();
    }
}
