package service.ui.text;

import domain.Graph;

public interface TextUiService {

  public String showInitialMenu();

  public void addCity(Graph graph);

  public void addRoute(Graph graph);

  public void calculateMst(Graph graph);

  public void calculateShortestPath(Graph graph);

  public void calculateShortestPathMst(Graph graph);

  public int saveAndExit(Graph graph);
  
}
