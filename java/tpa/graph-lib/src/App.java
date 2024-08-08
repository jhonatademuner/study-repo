import service.file.FileService;
import service.file.impl.FileServiceImpl;
import service.ui.text.TextUiService;
import service.ui.text.impl.TextUiServiceImpl;
import domain.Graph;
import domain.impl.GraphImpl;;

public class App {
  public static void main(String[] args) throws Exception {

    final TextUiService textUiService = new TextUiServiceImpl();
    final FileService fileService = new FileServiceImpl();
    final Graph graph = fileService.read();
    
    String chosenOption;

		do {
			chosenOption = textUiService.showInitialMenu();

			switch (chosenOption) {
				case "1":
          textUiService.addCity(graph);
					break;
				case "2":
          textUiService.addRoute(graph);
					break;
				case "3":
          textUiService.calculateMst(graph);
					break;
				case "4":
          textUiService.calculateShortestPath(graph);
					break;
				case "5":
          textUiService.calculateShortestPathMst(graph);
					break;
				case "6":
          textUiService.saveAndExit(graph);
					break;
        case "7":
          System.out.println("Saindo...");
          break;
				default:
					System.out.println("Opção inválida");
			}

		} while (!chosenOption.equals("7"));
  }
}
