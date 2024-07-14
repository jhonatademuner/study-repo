package app;

import java.io.IOException;
import java.util.Scanner;
import lib.IArvoreBinaria;

public class AppService {

	/*
	 * nextInt esta dando problema, uma solução do stackoverflow e usar o nextLine depois.
	 * FONTE: https://stackoverflow.com/questions/5032356/using-scanner-nextline
	 * Achamos que este problema e devido estarmos utilizando uma versão antiga do Java.
	 */
	
	Scanner sc = new Scanner(System.in);

	public AppService() {
	}

	public String showInitialMenu() {

		printTitle("Sistema de Gerenciamento de Alunos e Disciplinas");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Cadastrar Disciplina");
		System.out.println("3 - Informar pre-requisito");
		System.out.println("4 - Informar Disciplina cursada");
		System.out.println("5 - Consultar Aluno por Nome");
		System.out.println("6 - Consultar Aluno por Matricula");
		System.out.println("7 - Excluir Aluno por Matricula");
		System.out.println("8 - Sair do sistema");

      return sc.nextLine();
	}

	public void cadastrarAluno(IArvoreBinaria<Aluno> arvAluno) {

  	printTitle("Cadastro de Aluno");
		System.out.println("Digite a matricula do aluno: ");
		int matricula = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o nome do aluno: ");
		String nome = sc.nextLine();

		arvAluno.adicionar(new Aluno(matricula, nome));
		showQueryResult("Aluno cadastrado com sucesso!");
	}

	public void cadastrarDisciplina(IArvoreBinaria<Disciplina> arvDisciplina) {

		printTitle("Cadastro de Disciplina");
		System.out.println("Digite o codigo da disciplina: ");
		int codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o nome da disciplina: ");
		String nome = sc.nextLine();
		System.out.println("Digite a carga horaria da disciplina: ");
		int cargaHoraria = sc.nextInt();
		sc.nextLine();

		arvDisciplina.adicionar(new Disciplina(codigo, nome, cargaHoraria));
		showQueryResult("Disciplina cadastrada com sucesso!");
	}

	public void informarPreRequisito(IArvoreBinaria<Disciplina> arvDisciplina) {

		printTitle("Informar Pre-Requisito");
		System.out.println("Digite o codigo da disciplina que sera pre-requisito: ");
		int codigoPreReq = sc.nextInt();
		sc.nextLine();
		Disciplina preReq = arvDisciplina.pesquisar(new Disciplina(codigoPreReq, null, 0));

		System.out.println("Digite o codigo da disciplina que tera a anterior como pre-requisito: ");
		int codigo = sc.nextInt();
		sc.nextLine();
		Disciplina disciplina = arvDisciplina.pesquisar(new Disciplina(codigo, null, 0));

		for (Disciplina elem : disciplina.getPreReq()) {
			if (elem == disciplina) {
				showQueryResult("Disciplina informada ja esta cadastrada como pre-requisito");
				return;
			}
		}

		disciplina.addPreReq(preReq);
		showQueryResult("Pre-requisito informado com sucesso!");
	}

	public void informarDisciplinaCursada(IArvoreBinaria<Aluno> arvAluno, IArvoreBinaria<Disciplina> arvDisciplina) {

		printTitle("Informar Disciplina Cursada");
		System.out.println("Digite a matricula do aluno a ter disciplina cursada: ");
		int matricula = sc.nextInt();
		sc.nextLine();

		Aluno aluno = arvAluno.pesquisar(new Aluno(matricula, null));

		if (aluno == null) {
			System.out.println("Aluno não encontrado!");
			sc.close();
			return;
		}

		System.out.println("Digite o codigo da disciplina cursada: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		Disciplina disciplinaCursada = arvDisciplina.pesquisar(new Disciplina(codigo, null, 0));

		if (disciplinaCursada == null) {
			showQueryResult("Disciplina não encontrada!");
			return;
		}

		for (Disciplina elem : aluno.getDisciplinasCursadas()) {
			if (elem.getCodigo() == codigo) {
				System.out.println("Disciplina ja cursada!");
				return;
			}
		}

		for (Disciplina preReq : disciplinaCursada.getPreReq()) {
			if (!aluno.getDisciplinasCursadas().contains(preReq)) {
				showQueryResult("Aluno não possui pre-requisito para cursar a disciplina!");
				return;
			}
		}

		aluno.addDisciplinaCursada(disciplinaCursada);
		showQueryResult("Disciplina cursada informada com sucesso!");
	}

	public void consultarAlunoPorNome(IArvoreBinaria<Aluno> arvAluno) {

		printTitle("Consulta de Aluno por Nome");
		System.out.println("Digite o nome do aluno: ");
		String nome = sc.nextLine();

		Aluno aluno = arvAluno.pesquisar(new Aluno(0, nome), new ComparadorAlunoPorNome());

		if (aluno != null) {
			showQueryResult(aluno.toString());
		} else {
			showQueryResult("Aluno não encontrado!");
		}
	}

	public void consultarAlunoPorMatricula(IArvoreBinaria<Aluno> arvAluno) {

		printTitle("Consulta de Aluno por Matricula");
		System.out.println("Digite a matricula do aluno: ");
		int matricula = sc.nextInt();
		sc.nextLine();

		Aluno aluno = arvAluno.pesquisar(new Aluno(matricula, ""), new ComparadorAlunoPorMatricula());

		if (aluno != null) {
			showQueryResult(aluno.toString());
		} else {
			showQueryResult("Aluno não encontrado!");
		}
	}

	public void excluirAlunoPorMatricula(IArvoreBinaria<Aluno> arvAluno) {

		printTitle("Exclusão de Aluno por Matricula");
		System.out.println("Digite a matrícula do aluno a ser excluído: ");
		int matricula = sc.nextInt();
		sc.nextLine(); // Limpar o buffer do scanner

		Aluno aluno = arvAluno.pesquisar(new Aluno(matricula, ""));

		if (aluno != null) {
			arvAluno.remover(aluno);
			showQueryResult("Aluno excluído com sucesso!");
		} else {
			showQueryResult("Aluno não encontrado!");
		}
	}

	private void showQueryResult(String obj) {
		printTitle("Resultado da Consulta");
		System.out.println(obj);
		System.out.println("========================================");
		System.out.println("Pressione ENTER para continuar...");
		sc.nextLine();
	}

	private void printTitle(String title) {
		clearScreen();
		System.out.println("=".repeat(title.length() + 6));
		System.out.println("|| " + title + " ||");
		System.out.println("=".repeat(title.length() + 6));
	}

	private void clearScreen() {
		// System.out.print("\033[H\033[2J");
		// System.out.flush();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}	
