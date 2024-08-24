package domain;

import java.util.List;

public interface Graph<T> {

	List<Node<T>> getNodes();

	void setNodes(List<Node<T>> list);

	List<List<Float>> getAdjacencyMatrix();

	void setAdjacencyMatrix(List<List<Float>> adjacencyMatrix);

	int getNodesCount();

	void addNode(Node<T> node);

	void addEdge(String origin, String destiny, Float weight);

	Graph<T> getMst();

	String calculateMst(Node<T> node);

	String calculateShortestPathBetween(String node1, String node2);

	String calculateMstShortestPathBetween(String node1, String node2);

	String formatGraphString(Graph<T> mstGraph);

}
