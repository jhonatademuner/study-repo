// Com if, exiba  o nome do mês do ano de acordo com seu número.
// Evite o efeito "flecha". Faça também outro if que verifique se o
// mês é julho, dezembro ou janeiro, para assim exibir o texto "Férias".

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int num;
        String mes = "";

        Scanner input = new Scanner(System.in);

        System.out.println("Insira um número de 1 a 12");
        num = input.nextInt();

        if (num == 1){
            mes = "Janeiro";
        } else if (num == 2){
            mes = "Fevereiro";
        } else if (num == 3){
            mes = "Março";
        } else if (num == 4){
            mes = "Abril";
        } else if (num == 5){
            mes = "Maio";
        } else if (num == 6){
            mes = "Junho";
        } else if (num == 7){
            mes = "Julho";
        } else if (num == 8){
            mes = "Agosto";
        } else if (num == 9){
            mes = "Setembro";
        } else if (num == 10){
            mes = "Outubro";
        } else if (num == 11){
            mes = "Novembro";
        } else if (num == 12) {
            mes = "Dezembro";
        }

        if ((num == 1) || (num == 7) || (num == 12)) {
            mes = mes + " e é Férias";
        }

        System.out.println("Mês " + num + " é " + mes + ".");

        input.close();
    }
}
