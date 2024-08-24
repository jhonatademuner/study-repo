package service.file.impl;

import domain.Graph;
import domain.Node;
import domain.impl.NodeImpl;
import service.file.FileService;
import domain.impl.CityImpl;
import domain.impl.GraphImpl;
import domain.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class FileServiceImpl<T> implements FileService<T> {

  @SuppressWarnings("unchecked")
  @Override
  public Graph<T> read() {
    Graph<T> graph = new GraphImpl<T>();
    try {
      File file = new File("src/resource/entrada.txt");
      Scanner reader = new Scanner(file);
      int nodesCount = reader.nextInt();
      reader.nextLine();
      List<Node<T>> nodes = new ArrayList<Node<T>>();
      for (int i = 0; i < nodesCount; i++) {
        String cityName = reader.nextLine();
        City city = new CityImpl(cityName);
        nodes.add(new NodeImpl(city));
      }
      graph.setNodes(nodes);
      graph.setAdjacencyMatrix(new ArrayList<List<Float>>());
      for (int i = 0; i < nodesCount; i++) {
        List<Float> row = new ArrayList<Float>();
        String[] distances = reader.nextLine().split(",");
        for (String value : distances) {
          row.add(Float.parseFloat(value));
        }
        graph.getAdjacencyMatrix().add(row);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return new GraphImpl();
    }

    return graph;
  }

  @Override
  public void save(Graph<T> graph, String path) {
    try {
      File file = new File("src/resource" + path);
      file.createNewFile();
      FileWriter writer = new FileWriter(file);
      List<Node<T>> nodes = graph.getNodes();
      writer.write(nodes.size() + "\n");

      for (Node<T> node : nodes) {
        writer.write(((CityImpl) node.getValue()).getName() + "\n");
      }

      for (int i = 0; i < nodes.size(); i++) {
        for (int j = 0; j < nodes.size(); j++) {
          float distance = graph.getAdjacencyMatrix().get(i).get(j);
          writer.write((j == 0 ? "" : ",") + distance);
        }
        writer.write("\n");
      }
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}