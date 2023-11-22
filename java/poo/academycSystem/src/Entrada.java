
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 *
 * @author Hilario Seibel Junior, Jhonata Polito Demuner e João Pedro Spinassé Viana
 */
public class Entrada {
    public Scanner input;

    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scane vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("inputt.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     *
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) throws IOException {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = "0";
        try {
            if (input.hasNextLine()) linha = this.input.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println(e.getLocalizedMessage());
        }

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#'){
            if (input.hasNextLine()) {
                linha = this.input.nextLine();
            } else {
                linha = "0";
            }
        }
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     *
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = "-1";
        try {
            linha = this.lerLinha(msg);
        } catch (IOException | StringIndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     *
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = "-1";
        try {
            linha = this.lerLinha(msg);
        } catch (IOException | StringIndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     *
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu1() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar professor:\n" +
                "2) Cadastrar aluno:\n" +
                "3) Cadastrar turma:\n" +
                "4) Listar média das turmas:\n" +
                "0) Sair\n";

        int op = -1;

        do {
            try {
                op = this.lerInteiro(msg);
            } catch (NumberFormatException e) {
                System.out.println(e.getLocalizedMessage());;
            }
        } while (op < 0 || op > 4);

        return op;
    }

    /***************************************************/

    /**
     * Lê os dados de um novo Professor e cadastra-o no sistema.
     *
     * @param s: Um objeto da classe Sistema
     */
    public void cadProf(AcademicSys s) {
        s.printProfessors();

        try {
            String nome = this.lerLinha("Digite o nome do professor: ");
            String cpf = this.lerLinha("Digite o cpf do professor: ");
            double salario = this.lerDouble("Digite o salário do professor: R$");

            if (s.findProfessor(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
                Professor p = new Professor(nome, cpf, salario);
                s.addProfessor(p);
            } else {
                System.out.println("Erro: CPF duplicado. Professor não adicionado.");
            }
        } catch (IOException | StringIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Lê os dados de um novo Aluno e cadastra-o no sistema.
     *
     * @param s: Um objeto da classe Sistema
     */
    public void cadAluno(AcademicSys s) {
        s.printProfessors();

        try {
            String nome = this.lerLinha("Digite o nome do aluno: ");
            String cpf = this.lerLinha("Digite o cpf do aluno: ");
            String mat = this.lerLinha("Digite a matrícula do aluno: ");
            if (s.findStudent(mat) == null) { // Garantindo que a matrícula não esteja duplicada.
                Student a = new Student(nome, cpf, mat);
                s.addStudent(a);
            } else {
                System.out.println("Erro: Matrícula duplicada. Aluno não adicionado.");
            }
        } catch (IOException | StringIndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /***************************************************/

    /**
     * Lê o CPF de um professor e localiza-o no sistema.
     *
     * @param s: Um objeto da classe Sistema
     * @return Um objeto da classe Professor.
     */
    private Professor lerProf(AcademicSys s) {
        s.printProfessors();

        String cpf = "";
        Professor p;
        do {
            try {
                cpf = this.lerLinha("Digite o CPF do professor: ");
            } catch (IOException | StringIndexOutOfBoundsException e) {
                System.out.println(e.getLocalizedMessage());
            }
            p = s.findProfessor(cpf);
        } while (p == null);
        return p;

    }

    /**
     * Lê um número de alunos, depois a matrícula de cada aluno e localiza-os no sistema.
     *
     * @param s: Um objeto da classe Sistema
     * @return Um array contendo todos os objetos da classe Aluno cujas matrículas foram digitadas.
     */
    private Student[] lerAlunos(AcademicSys s) {
        int nAlunos = 0;

        do {
            nAlunos = this.lerInteiro("Digite a quantidade de alunos na disciplina: ");
        } while (nAlunos > s.getStudents().size() || nAlunos <= 0);

        Student[] alunos = new Student[nAlunos];

        for (int i = 0; i < nAlunos; i++) {
            s.printStudents();

            String mat = "";
            Student a = null;

            do {
                try {
                    mat = this.lerLinha("Digite a matrícula do aluno: ");
                } catch (IOException | StringIndexOutOfBoundsException e) {
                    System.out.println(e.getLocalizedMessage());
                }
                a = s.findStudent(mat);
            } while (a == null);

            alunos[i] = a;

        }

        return alunos;
    }

    /**
     * Lê as notas de um aluno em uma prova.
     *
     * @param s: Um objeto da classe Sistema
     * @param a: Um objeto da classe Aluno
     * @param nQuestoes: Inteiro com o número de questões nesta prova
     * @return Um objeto da classe AlunoProva, com as respectivas as notas do aluno em cada questão da prova.
     */
    private StudentExam lerAlunoProva(AcademicSys s, Student a, int nQuestoes) {
        double[] notas = new double[nQuestoes];

        for (int i = 0; i < nQuestoes; i++) {
            notas[i] = lerDouble("Nota de " + a.getName() + " na questão " + (i + 1) + ": ");
        }

        return new StudentExam(a, notas);
    }

    /**
     * Lê os dados de uma Prova.
     *
     * @param s:      Um objeto da classe Sistema
     * @param alunos: Um array com todos os alunos que fizeram esta prova.
     * @return Um novo objeto da classe Prova com todos os dados que foram lidos.
     */
    private Exam lerProva(AcademicSys s, Student[] alunos) {


        String nome = null;
        try {
            nome = this.lerLinha("Informe o nome desta prova: ");
        } catch (IOException | StringIndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        }

        int dia = this.lerInteiro("Digite o dia da prova: ");
        int mes = this.lerInteiro("Digite o mês da prova: ");
        int ano = this.lerInteiro("Digite o ano da prova: ");
        TimeDate aplic = new TimeDate(dia, mes, ano);

        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int nQuestoes = this.lerInteiro("Digite o número de questões: ");

        StudentExam[] notas = new StudentExam[alunos.length];
        for (int i = 0; i < alunos.length; i++) {
            notas[i] = this.lerAlunoProva(s, alunos[i], nQuestoes);
        }

        return new Exam(nome, aplic, valor, nQuestoes, notas);
    }

    /**
     * Lê a avaliação que o professor fez de um aluno em um trabalho.
     *
     * @param s: Um objeto da classe Sistema
     * @param a: Um objeto da classe Aluno
     * @return Um objeto da classe AlunoTrab com as informações lidas sobre o aluno neste trabalho.
     */
    private StudentAssessment lerAlunoTrab(AcademicSys s, Student a) {
        double nota = this.lerDouble("Nota do " + a.getName() + " no trabalho: ");

        int dia = this.lerInteiro("Digite o dia de entrega do trabalho: ");
        int mes = this.lerInteiro("Digite o mês de entrega do trabalho: ");
        int ano = this.lerInteiro("Digite o ano de entrega do trabalho: ");
        TimeDate entrega = new TimeDate(dia, mes, ano);

        int tempoExec = this.lerInteiro("Informe o tempo de processamento: ");

        return new StudentAssessment(a, nota, entrega, tempoExec);
    }

    /**
     * Lê os dados de um Trabalho.
     *
     * @param s: Um objeto da classe Sistema
     * @param alunos: Um array com todos os alunos que fizeram esta prova.
     * @return Um novo objeto da classe Trabalho com todos os dados que foram lidos.
     */
    private Assessment lerTrabalho(AcademicSys s, Student[] alunos) {

        String nome = null;
        try {
            nome = this.lerLinha("Informe o nome desta avaliação: ");
        } catch (IOException | StringIndexOutOfBoundsException e) {
            System.out.println(e.getLocalizedMessage());
        }

        int dia = this.lerInteiro("Digite o dia do trabalho: ");
        int mes = this.lerInteiro("Digite o mês do trabalho: ");
        int ano = this.lerInteiro("Digite o ano do trabalho: ");
        TimeDate aplic = new TimeDate(dia, mes, ano);

        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int tempoEsp = this.lerInteiro("Digite o tempo esperado pelo professor: ");

        StudentAssessment[] notas = new StudentAssessment[alunos.length];
        for (int i = 0; i < alunos.length; i++) {
            notas[i] = this.lerAlunoTrab(s, alunos[i]);
        }

        return new Assessment(nome, aplic, valor, tempoEsp, notas);
    }

    /**
     * Lê as avaliações de uma certa disciplina.
     *
     * @param s: Um objeto da classe Sistema
     * @param alunos: Um array com todos os alunos que fizeram esta prova.
     * @return Um array com todas as avaliações da disciplina.
     */
    private Evaluation[] lerAvaliacoes(AcademicSys s, Student[] alunos) {
        int nAvaliacoes = this.lerInteiro("Digite a quantidade de avaliações na disciplina: ");
        Evaluation[] avs = new Evaluation[nAvaliacoes];

        for (int i = 0; i < nAvaliacoes; i++) {
            int op = this.lerInteiro("Escolha um tipo de avaliação:\n1) Prova\n2) Trabalho");

            while (op != 1 && op != 2) {
                op = this.lerInteiro("Tipo de avaliação inválida. Tente novamente: ");
            }

            if (op == 1) avs[i] = this.lerProva(s, alunos);
            else avs[i] = this.lerTrabalho(s, alunos);
        }

        return avs;
    }

    /**
     * Lê os dados de uma Turma.
     *
     * @param s: Um objeto da classe Sistema
     * @return Um novo objeto da classe Turma com todos os dados desta turma.
     */
    public void cadTurma(AcademicSys s) {
        try {
            String disciplina = this.lerLinha("Digite o nome da disciplina: ");
            int ano = this.lerInteiro("Digite o ano da disciplina: ");
            int sem = this.lerInteiro("Digite o semestre da disciplina: ");

            Professor p = this.lerProf(s);
            Student[] alunos = this.lerAlunos(s);
            Evaluation[] avs = this.lerAvaliacoes(s, alunos);

            s.addCourse(new Course(disciplina, ano, sem, p, alunos, avs));
        } catch (IOException | StringIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
