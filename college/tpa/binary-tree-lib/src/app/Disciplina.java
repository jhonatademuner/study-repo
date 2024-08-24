package app;

import java.util.List;
import java.util.ArrayList;

public class Disciplina {
    private int codigo;
    private String nome;
    private int cargaHoraria;
    private List<Disciplina> preRequisitos = new ArrayList<Disciplina>();
    private ComparadorDisciplinaPorCodigo comp = new ComparadorDisciplinaPorCodigo();

    public Disciplina(int codigo,String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Disciplina> getPreReq() {
        return preRequisitos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void addPreReq(Disciplina disciplina) {
        if(this != disciplina){
            this.preRequisitos.add(disciplina);
        } else {
            System.out.println("Disciplina não pode ser pre-requisito dela mesma");
        }
    }

    public String toString() {
        return "Codigo: " + codigo + 
        "\nNome: " + nome +
        "\nCargaHoraria: " + cargaHoraria +
        "\nPré-requisito(s): " + preRequisitos;
    }
}