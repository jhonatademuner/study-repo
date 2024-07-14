package app;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author victoriocarvalho
 * 
 * Essa é a classe Aluno que será utilizada como tipo do conteúdo das árvores nos 
 * programas de teste para redigir os relatórios.
 */

public class Aluno  {
    private int matricula;
    private String nome;
    private List<Disciplina> disciplinasCursadas;

    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome; 
        this.disciplinasCursadas = new ArrayList<Disciplina>();       
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void addDisciplinaCursada(Disciplina disciplina) {
        this.disciplinasCursadas.add(disciplina);
    }

    public String toString(){
        return "Matricula: " + matricula +
        "\nNome: " + nome +
        "\nDisciplinas Cursadas: " + disciplinasCursadas;
    }

}
