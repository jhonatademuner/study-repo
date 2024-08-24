package service.ui.text.impl;

import java.util.List;
import java.util.Scanner;

import domain.City;
import domain.Graph;
import domain.impl.CityImpl;
import domain.impl.NodeImpl;
import service.file.FileService;
import service.file.impl.FileServiceImpl;
import service.ui.text.TextUiService;
import utils.service.ui.text.AbstractTextUiService;

public class TextUiServiceImpl<T> extends AbstractTextUiService implements TextUiService<T> {

  Scanner sc = new Scanner(System.in);
  FileService<T> fileService = new FileServiceImpl<T>();

  @Override
  public String showInitialMenu() {
    List<String> options = List.of(
        "1 - Acrescentar cidade",
        "2 - Acrescentar rota",
        "3 - Calcular árvore geradora mínima (AGM)",
        "4 - Calcular caminho mínimo entre duas cidades",
        "5 - Calcular caminho mínimo entre duas cidades considerando apenas a AGM",
        "6 - Gravar e Sair",
        "7 - Sair");
    return super.showInitialMenu(options);
  }

  @Override
  public void addCity(Graph<City> graph) {
    printTitle("Adicionar cidade");
    System.out.println("Nome da cidade: ");
    String cityName = sc.nextLine();
    City city = new CityImpl(cityName);
    graph.addNode(new NodeImpl<City>(city));
    showResult(cityName + " adicionada com sucesso!");
  }

  @Override
  public void addRoute(Graph<City> graph) {
    printTitle("Adicionar rota");
    System.out.println("Nome da cidade de origem: ");
    String originCityName = sc.nextLine();
    System.out.println("Nome da cidade de destino: ");
    String destinationCityName = sc.nextLine();
    System.out.println("Distância: ");
    float distance = sc.nextFloat();
    sc.nextLine();
    graph.addEdge(originCityName, destinationCityName, distance);
    showResult("Rota adicionada com sucesso!");
  }

  @Override
  public void calculateMst(Graph<T> graph) {
    showResult(graph.calculateMst(graph.getNodes().get(0)));
  }

  @Override
  public void calculateShortestPath(Graph<T> graph) {
    printTitle("Calcular caminho mínimo entre duas cidades");
    System.out.println("Nome da cidade de origem: ");
    String originCityName = sc.nextLine();
    System.out.println("Nome da cidade de destino: ");
    String destinationCityName = sc.nextLine();
    showResult(graph.calculateShortestPathBetween(originCityName, destinationCityName));
  }

  @Override
  public void calculateShortestPathMst(Graph<T> graph) {
    printTitle("Calcular caminho mínimo entre duas cidades considerando apenas a AGM");
    System.out.println("Nome da cidade de origem: ");
    String originCityName = sc.nextLine();
    System.out.println("Nome da cidade de destino: ");
    String destinationCityName = sc.nextLine();
    showResult(graph.calculateMstShortestPathBetween(originCityName, destinationCityName));
  }

  @Override
  public int saveAndExit(Graph<T> graph) {
    printTitle("Gravar e Sair");
    fileService.save(graph, "/grafoCompleto.txt");
    if(graph.getMst() != null){
      fileService.save(graph.getMst(), "/agm.txt");
    }
    showResult("Arquivos salvos com sucesso!");
    return 7;
  }

}
