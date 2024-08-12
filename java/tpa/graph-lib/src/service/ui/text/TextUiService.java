package service.ui.text;

import domain.City;
import domain.Graph;

public interface TextUiService<T> {

  public String showInitialMenu();

  public void addCity(Graph<City> graph);

  public void addRoute(Graph<City> graph);

  public void calculateMst(Graph<T> graph);

  public void calculateShortestPath(Graph<T> graph);

  public void calculateShortestPathMst(Graph<T> graph);

  public int saveAndExit(Graph<T> graph);
  
}
