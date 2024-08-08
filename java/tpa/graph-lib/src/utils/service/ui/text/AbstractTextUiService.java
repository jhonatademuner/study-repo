package utils.service.ui.text;

import java.util.Scanner;
import java.util.List;

public abstract class AbstractTextUiService {

	
  Scanner sc = new Scanner(System.in);


  public String showInitialMenu(List<String> options) {

		printTitle("Sistema de Gerenciamento de Alunos e Disciplinas");
    for (String option : options) {
      System.out.println(option);
    }

    return sc.nextLine();
	}
  
  public void showResult(Object obj) {
		printTitle("Resultado da Consulta");
		System.out.println(obj);
		System.out.println("========================================");
		System.out.println("Pressione ENTER para continuar...");
		sc.nextLine();
	}

	public void printTitle(String title) {
		clearScreen();
		System.out.println("=".repeat(title.length() + 6));
		System.out.println("|| " + title + " ||");
		System.out.println("=".repeat(title.length() + 6));
	}

	public void clearScreen() {
		// System.out.print("\033[H\033[2J");
		// System.out.flush();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
  
}