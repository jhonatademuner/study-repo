import service.FileService;
import service.impl.FileServiceImpl;
import domain.Graph;
import domain.Node;

public class App {
  public static void main(String[] args) throws Exception {
    
    FileService fileService = new FileServiceImpl();

    Graph cityGraph = fileService.read("entrada.txt");

    System.out.println(cityGraph);

    fileService.save(cityGraph, "grafoCompleto.txt");
    Node node = cityGraph.getNodes().toArray()[0];
    fileService.saveMst(cityGraph.calculateMst(node), "agm.txt");
  }
}
