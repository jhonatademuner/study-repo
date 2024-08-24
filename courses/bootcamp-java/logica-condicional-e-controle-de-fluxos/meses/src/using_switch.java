// Com if, exiba  o nome do mês do ano de acordo com seu número.
// Evite o efeito "flecha". Faça também outro if que verifique se o
// mês é julho, dezembro ou janeiro, para assim exibir o texto "Férias".

// Mesmo programa, porém feito usando switch ao invés de else-if:

import java.util.Scanner;

public class using_switch {

     public static void main(String[] args) {

         int num;
         String mes = "";

         Scanner input = new Scanner(System.in);

         System.out.println("Insira um número de 1 a 12");
         num = input.nextInt();

         switch (num) {
             case 1:
                 mes = "Janeiro";
                 break;
             case 2:
                 mes = "Fevereiro";
                 break;
             case 3:
                 mes = "Março";
                 break;
             case 4:
                 mes = "Abril";
                 break;
             case 5:
                 mes = "Maio";
                 break;
             case 6:
                 mes = "Junho";
                 break;
             case 7:
                 mes = "Julho";
                 break;
             case 8:
                 mes = "Agosto";
                 break;
             case 9:
                 mes = "Setembro";
                 break;
             case 10:
                 mes = "Outubro";
                 break;
             case 11:
                 mes = "Novembro";
                 break;
             case 12:
                 mes = "Dezembro";
                 break;
         }

         if ((num == 1) || (num == 7) || (num == 12)) {
             mes = mes + " e é Férias";
         }

         System.out.println("Mês " + num + " é " + mes + ".");

         input.close();
     }
 }