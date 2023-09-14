// package Notas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior, Jhonata Polito Demuner e João Pedro Spinassé Viana
 */

public class Input {
    public Scanner input;


    /**
     * Construtor da classe InputOutput
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Input() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    private String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.charAt(0) == '#') linha = this.input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    private int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    private double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public int menu1() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar professor:\n" +
                "2) Cadastrar aluno:\n" +
                "3) Cadastrar turma:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 3) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /***************************************************/

    /**
     * Lê os dados de um novo Professor e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    /*public void cadProf(Sistema s) {
        s.listarProfs();

        String nome = this.lerLinha("Digite o nome do professor: ");
        String cpf = this.lerLinha("Digite o cpf do professor: ");
        double salario = this.lerDouble("Digite o salário do professor: R$");

        if (s.encontrarProfessor(cpf) == null) { // Garantindo que o não CPF esteja duplicado.
            Professor p = new Professor(nome, cpf, salario);
            s.novoProf(p);
        }
        else {
            System.out.println("Erro: CPF duplicado. Professor não adicionado.");
        }
    }*/

    /**
     * Lê os dados de um novo Aluno e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    /*public void cadAluno(Sistema s) {
        s.listarAlunos();

        String nome = this.lerLinha("Digite o nome do aluno: ");
        String cpf = this.lerLinha("Digite o cpf do aluno: ");
        String mat = this.lerLinha("Digite a matrícula do aluno: ");

        if (s.encontrarAluno(mat) == null) { // Garantindo que a matrícula não esteja duplicada.
            Aluno a = new Aluno(nome, cpf, mat);
            s.novoAluno(a);
        }
        else {
            System.out.println("Erro: Matrícula duplicada. Aluno não adicionado.");
        }
    }*/

    /***************************************************/

    /**
     * Lê o CPF de um professor e localiza-o no sistema.
     * @param s: Um objeto da classe Sistema
     * @return Um objeto da classe Professor.
     */
    /*private Professor lerProf(Sistema s) {
        s.listarProfs();

        String cpf = this.lerLinha("Digite o CPF do professor: ");
        Professor p = s.encontrarProfessor(cpf);

        while (p == null) {
            cpf = this.lerLinha("CPF inválido. Digite outro: ");
            p = s.encontrarProfessor(cpf);
        }

        return p;
    }*/

    /**
     * Lê um número de alunos, depois a matrícula de cada aluno e localiza-os no sistema.
     * @param s: Um objeto da classe Sistema
     * @return Um array contendo todos os objetos da classe Aluno cujas matrículas foram digitadas.
     */
    /*private Aluno[] lerAlunos(Sistema s) {
        int nAlunos = this.lerInteiro("Digite a quantidade de alunos na disciplina: ");
        Aluno[] alunos = new Aluno[nAlunos];

        for(int i=0; i<nAlunos; i++) {
            s.listarAlunos();

            String mat = this.lerLinha("Digite a matrícula do aluno: ");
            Aluno a = s.encontrarAluno(mat);

            while (a == null) {
                mat = this.lerLinha("Matrícula inválida. Digite outra: ");
                a = s.encontrarAluno(mat);
            }

            alunos[i] = a;
        }

        return alunos;
    }*/

    /**
     * Lê as notas de um aluno em uma prova.
     * @param s: Um objeto da classe Sistema
     * @param a: Um objeto da classe Aluno
     * @param nQuestoes: Inteiro com o número de questões nesta prova
     * @return Um objeto da classe AlunoProva, com as respectivas as notas do aluno em cada questão da prova.
     */
    /*private AlunoProva lerAlunoProva(Sistema s, Aluno a, int nQuestoes) {
        double[] notas = new double[nQuestoes];

        for (int i=0; i<nQuestoes; i++) {
            notas[i] = lerDouble("Nota de " + a.getNome() + " na questão " + (i+1) + ": ");
        }

        return new AlunoProva(a, notas);
    }*/

    /**
     * Lê os dados de uma Prova.
     * @param s: Um objeto da classe Sistema
     * @param alunos: Um array com todos os alunos que fizeram esta prova.
     * @return Um novo objeto da classe Prova com todos os dados que foram lidos.
     */
    /*private Prova lerProva(Sistema s, Aluno[] alunos) {
        String nome = this.lerLinha("Informe o nome desta prova: ");

        int dia = this.lerInteiro("Digite o dia da prova: ");
        int mes = this.lerInteiro("Digite o mês da prova: ");
        int ano = this.lerInteiro("Digite o ano da prova: ");
        Data aplic = new Data(dia, mes, ano);

        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int nQuestoes = this.lerInteiro("Digite o número de questões: ");

        AlunoProva[] notas = new AlunoProva[alunos.length];
        for (int i = 0; i< alunos.length; i++) {
            notas[i] = this.lerAlunoProva(s, alunos[i], nQuestoes);
        }

        return new Prova(nome, aplic, valor, nQuestoes, notas);
    }*/

    /**
     * Lê a avaliação que o professor fez de um aluno em um trabalho.
     * @param s: Um objeto da classe Sistema
     * @param a: Um objeto da classe Aluno
     * @return Um objeto da classe AlunoTrab com as informações lidas sobre o aluno neste trabalho.
     */
    /*private AlunoTrab lerAlunoTrab(Sistema s, Aluno a) {
        double nota = this.lerDouble("Nota do " + a.getNome() + " no trabalho: ");

        int dia = this.lerInteiro("Digite o dia de entrega do trabalho: ");
        int mes = this.lerInteiro("Digite o mês de entrega do trabalho: ");
        int ano = this.lerInteiro("Digite o ano de entrega do trabalho: ");
        Data entrega = new Data(dia, mes, ano);

        int tempoExec = this.lerInteiro("Informe o tempo de processamento: ");

        return new AlunoTrab(a, nota, entrega, tempoExec);
    }*/

    /**
     * Lê os dados de um Trabalho.
     * @param s: Um objeto da classe Sistema
     * @param alunos: Um array com todos os alunos que fizeram esta prova.
     * @return Um novo objeto da classe Trabalho com todos os dados que foram lidos.
     */
    /*private Trabalho lerTrabalho(Sistema s, Aluno[] alunos) {
        String nome = this.lerLinha("Informe o nome desta avaliação: ");

        int dia = this.lerInteiro("Digite o dia do trabalho: ");
        int mes = this.lerInteiro("Digite o mês do trabalho: ");
        int ano = this.lerInteiro("Digite o ano do trabalho: ");
        Data aplic = new Data(dia, mes, ano);

        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int tempoEsp = this.lerInteiro("Digite o tempo esperado pelo professor: ");

        AlunoTrab[] notas = new AlunoTrab[alunos.length];
        for (int i=0; i<alunos.length; i++) {
            notas[i] = this.lerAlunoTrab(s, alunos[i]);
        }

        return new Trabalho(nome, aplic, valor, tempoEsp, notas);
    }*/

    /**
     * Lê as avaliações de uma certa disciplina.
     * @param s: Um objeto da classe Sistema
     * @param alunos: Um array com todos os alunos que fizeram esta prova.
     * @return Um array com todas as avaliações da disciplina.
     */
    /*private Avaliacao[] lerAvaliacoes(Sistema s, Aluno[] alunos) {
        int nAvaliacoes = this.lerInteiro("Digite a quantidade de avaliações na disciplina: ");
        Avaliacao[] avs = new Avaliacao[nAvaliacoes];

        for (int i=0; i<nAvaliacoes; i++) {
            int op = this.lerInteiro("Escolha um tipo de avaliação:\n1) Prova\n2) Trabalho");

            while (op != 1 && op != 2) {
                op = this.lerInteiro("Tipo de avaliação inválida. Tente novamente: ");
            }

            if (op == 1) avs[i] = this.lerProva(s, alunos);
            else avs[i] = this.lerTrabalho(s, alunos);
        }

        return avs;
    }*/

    /**
     * Lê os dados de uma Turma.
     * @param s: Um objeto da classe Sistema
     * @return Um novo objeto da classe Turma com todos os dados desta turma.
     */
    /*public Turma cadTurma(Sistema s) {
        String disciplina = this.lerLinha("Digite o nome da disciplina: ");
        int ano = this.lerInteiro("Digite o ano da disciplina: ");
        int sem = this.lerInteiro("Digite o semestre da disciplina: ");

        Professor p = this.lerProf(s);
        Aluno[] alunos = this.lerAlunos(s);
        Avaliacao[] avs = this.lerAvaliacoes(s, alunos);

        return new Turma(disciplina, ano, sem, p, alunos, avs);

    }*/

}