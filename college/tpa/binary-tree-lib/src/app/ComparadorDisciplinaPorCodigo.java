package app;

import java.util.Comparator;

public class ComparadorDisciplinaPorCodigo implements Comparator<Disciplina> {
	/*O nosso comparador utiliza o método compare da classe integer para comparar as matrículas de 2 alunos
	*Eu poderia ter feito um if para vrificar qual matrícula é maior e retornar 1, -1 ou 0...
	*/    
	@Override
	public int compare(Disciplina o1, Disciplina o2) {
			return Integer.compare(o1.getCodigo(), o2.getCodigo());
	}

}