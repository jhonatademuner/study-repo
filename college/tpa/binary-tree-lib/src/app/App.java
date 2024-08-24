package app;

import lib.BinaryTreeImpl;
import lib.IArvoreBinaria;

public class App {

	public static void main(String[] args) {
		IArvoreBinaria<Aluno> arvAluno;
		IArvoreBinaria<Disciplina> arvDisciplina;

		AppService appService = new AppService();

		arvAluno = new BinaryTreeImpl<Aluno>(new ComparadorAlunoPorMatricula());
		arvDisciplina = new BinaryTreeImpl<Disciplina>(new ComparadorDisciplinaPorCodigo());

		String chosenOption;

		do {
			chosenOption = appService.showInitialMenu();

			switch (chosenOption) {
				case "1":
					appService.cadastrarAluno(arvAluno);
					break;
				case "2":
					appService.cadastrarDisciplina(arvDisciplina);
					break;
				case "3":
					appService.informarPreRequisito(arvDisciplina);
					break;
				case "4":
					appService.informarDisciplinaCursada(arvAluno, arvDisciplina);
					break;
				case "5":
					appService.consultarAlunoPorNome(arvAluno);
					break;
				case "6":
					appService.consultarAlunoPorMatricula(arvAluno);
					break;
				case "7":
					appService.excluirAlunoPorMatricula(arvAluno);
					break;
				case "8":
					break;
				default:
					System.out.println("Opção inválida");
			}

		} while (!chosenOption.equals("8"));

	}
}
