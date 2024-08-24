// Com switch use String para a partir do dia da semana, exibir seu
// número. Ainda no switch, faça outro exemplo onde, se uma
// variável inteira for entre 1 e 3 exibir o texto "Certo". Se for 4
// exibir "Errado", se for 5 "Talvez". Pra demais valores exibir
// "Valor Indefinido".

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        String dia;
        int num = 0;
        String result;

        Scanner input = new Scanner(System.in);

        System.out.println("Insira um dia da semana:");

        dia = input.next();

        switch (dia) {
            case "Domingo":
                num = 1;
                break;
            case "Segunda":
                num = 2;
                break;
            case "Terça":
                num = 3;
                break;
            case "Quarta":
                num = 4;
                break;
            case "Quinta":
                num = 5;
                break;
            case "Sexta":
                num = 6;
                break;
            case "Sábado":
                num = 7;
                break;
        }

        switch (num) {
            case 1:
            case 2:
            case 3:
                result = "Certo";
                break;
            case 4:
                result = "Errado";
                break;
            case 5:
                result = "Talvez";
                break;
            default:
                result = "Valor Indefinido";
                break;
        }

        System.out.println(dia + " é o " + num + " dia da semana e o resultado é: " + result + ".");

        input.close();
    }
}
