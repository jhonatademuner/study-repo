package service.file.impl;

import domain.Graph;
import domain.Node;
import domain.impl.NodeImpl;
import service.file.FileService;
import domain.impl.CityImpl;
import domain.impl.GraphImpl;
import domain.City;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class FileServiceImpl implements FileService {

  @Override
  public Graph read() {
    Graph graph = new GraphImpl();
    try {
      File file = new File("src/resource/entrada.txt");
      Scanner reader = new Scanner(file);
      int nodesCount = reader.nextInt();
      reader.nextLine();
      List<Node> nodes = new ArrayList<Node>();
      for (int i = 0; i < nodesCount; i++) {
        String cityName = reader.nextLine();
        City city = new CityImpl(cityName);
        nodes.add(new NodeImpl<City>(city));
      }
      graph.setNodes(nodes);
      graph.setAdjacencyMatrix(new ArrayList<List<Float>>());
      for(int i = 0; i < nodesCount; i++) {
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
    
    
    graph.updateNodesCount();
    return graph;
  }

  @Override
  public void save(Graph graph) {

    try {

      File file = new File("src/resource/grafoCompleto.txt");
      file.createNewFile();
      FileWriter writer = new FileWriter(file);
      List<Node> nodes = graph.getNodes();
      writer.write(nodes.size() + "\n");

      for (Node<City> node : nodes) {
        writer.write(node.getValue().getName() + "\n");
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