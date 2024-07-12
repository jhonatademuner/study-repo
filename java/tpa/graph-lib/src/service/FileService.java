package service;

import domain.Graph;
import domain.Node;
import java.util.List;

public interface FileService {
  
    Graph read(String path);

    void save(Graph graph, String path);

    void saveMst(List<Node> mst, String path);
  
}
