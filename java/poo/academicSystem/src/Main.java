// package Notas;

/**
 * Classe principal
 * @author Hilario Seibel Junior
 */
public class Main {
    public static void main(String[] args) {
        Input io = new Input();
//        Sistema s = new Sistema();

        int op = io.menu1();

        while (op != 0) {
            if (op == 1) {
                System.out.println("Entrei no cadastro do professor. Apague isso aqui depois!");
                //io.cadProf(s);
            }
            if (op == 2) {
                System.out.println("Entrei no cadastro do aluno.");
                //io.cadAluno(s);
            }
            if (op == 3) {
                System.out.println("Entrei no cadastro da turma.");
                //Turma t = io.cadTurma(s);
                //t.medias();
            }

            op = io.menu1();
        }
    }
}