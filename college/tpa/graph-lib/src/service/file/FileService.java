package service.file;

import domain.Graph;

public interface FileService<T> {

    Graph<T> read();

    void save(Graph<T> graph, String path);

}
