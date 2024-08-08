package service.file;

import domain.Graph;
import domain.Node;
import java.util.List;

public interface FileService {
  
    Graph read();

    void save(Graph graph);

    @SuppressWarnings("rawtypes")
    void saveMst(List<Node> mst, String path);
  
}
