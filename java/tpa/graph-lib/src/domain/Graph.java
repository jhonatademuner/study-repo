package domain;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface Graph {

	List<Node> getNodes();

	void setNodes(List<Node> nodes);

	List<List<Float>> getAdjacencyMatrix();

	void setAdjacencyMatrix(List<List<Float>> adjacencyMatrix);

	int getNodesCount();

	void addNode(Node node);

	void addEdge(String origin, String destiny, Float weight);

	List<Node> calculateMst(Node node);

	String calculateShortestPathBetween(String node1, String node2);

	void calculateMstShortestPathBetween(Node node);

}
