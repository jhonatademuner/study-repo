import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        float num1;
        float num2;
        char sinal;

        System.out.println("Esse programa funciona como uma calculadora, este programa foi feito afim de exercitar os conteúdos do curso - Entendendo Métodos Java.");

        Scanner input = new Scanner(System.in);

        System.out.println("Insira o primeiro número:");
        num1 = input.nextFloat();

        System.out.println("Para adição digite: +\nPara subtração digite: -\nPara multiplicação digite: *\nPara divisão digite: /");
        sinal = input.next().charAt(0);

        System.out.println("Insira o segundo número:");
        num2 = input.nextFloat();

        if (sinal == '+') {
            System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
        } else {
            if (sinal == '-'){
                System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
            } else {
                if (sinal == '*'){
                    System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
                } else {
                    if (sinal == '/') {
                        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                    }
                }
            }
        }
        input.close();
    }
}
