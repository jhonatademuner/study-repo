/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
//Lembre-se de ajustar os imports!!!!!
import lib.AVLTreeImpl;
import lib.BinaryTreeImpl;
import lib.IArvoreBinaria;

/**
 *
 * @author victoriocarvalho
 * 
 * Classe principal do aplicativo a ser utilizado para fazer o relatório do trabalho 
 * de árvore AVL
 */
public class AppRelatorioAVL {
    @SuppressWarnings({ "unchecked", "rawtypes" }) //Anotação para suprimir avisos de compilação
    public static void main(String[] args) {

        GeradorDeArvores gerador = new GeradorDeArvores();
        ComparadorAlunoPorMatricula comparador = new ComparadorAlunoPorMatricula();
        IArvoreBinaria<Aluno> arv;

        arv = new AVLTreeImpl(comparador);
        gerador.geraArvoreDegenerada(100, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new BinaryTreeImpl(comparador);
        gerador.geraArvoreDegenerada(100, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new AVLTreeImpl(comparador);
        gerador.geraArvoreDegenerada(1000, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new BinaryTreeImpl(comparador);
        gerador.geraArvoreDegenerada(1000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new AVLTreeImpl(comparador);
        gerador.geraArvoreDegenerada(10000, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new BinaryTreeImpl(comparador);
        gerador.geraArvoreDegenerada(10000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        
    }
}
