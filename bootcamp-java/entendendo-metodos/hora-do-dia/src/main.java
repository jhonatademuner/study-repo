// A partir da hora do dia, informe a mensagem adequada:
// Bom dia, Boa tarde e Boa noite.

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int hora;

        Scanner input = new Scanner(System.in);

        System.out.println("Insira a hora:");
        hora = input.nextInt();

        switch (hora) {
            case 24:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                System.out.println("Bom dia. Agora são " + hora + " horas.");
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                System.out.println("Boa tarde. Agora são " + hora + " horas.");
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                System.out.println("Boa noite. Agora são " + hora + " horas.");
                break;
        }
            input.close();
    }
}
