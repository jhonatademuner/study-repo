package service.impl;

import domain.Graph;
import domain.Node;
import domain.impl.NodeImpl;
import domain.impl.CityImpl;
import domain.impl.GraphImpl;
import domain.City;
import service.FileService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class FileServiceImpl implements FileService {

  @Override
  public Graph read(String path) {
    Graph graph = new GraphImpl();
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      int numberOfCities = Integer.parseInt(br.readLine().trim());
      List<Node> cities = new ArrayList<>();

      for (int i = 0; i < numberOfCities; i++) {
        String cityName = br.readLine().trim();
        cities.add(new NodeImpl<City>(new CityImpl(cityName)));
        graph.addNode(cities.get(i));
      }

      for (int i = 0; i < numberOfCities; i++) {
        String[] distances = br.readLine().split(",");
        for (int j = 0; j < distances.length; j++) {
          float distance = Float.parseFloat(distances[j].trim());
          if (distance != 0) {
            graph.addEdge(cities.get(i), cities.get(j), distance);
          }
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return graph;
  }

  @Override
  public void save(Graph graph, String path) {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
      Set<Node> nodes = graph.getNodes();
      bw.write(nodes.size() + "\n");

      for (Node<City> node : nodes) {
        bw.write(node.getValue().getName() + "\n");
      }

      for (int i = 0; i < nodes.size(); i++) {
        for (int j = 0; j < nodes.size(); j++) {
          float distance = graph.getAdjacencyMatrix().get(i).get(j);
          bw.write((j == 0 ? "" : ",") + distance);
        }
        bw.write("\n");
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void saveMst(List<Node> mst, String path) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
      for (Node<City> node : mst) {
        bw.write(node.getValue().getName() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}