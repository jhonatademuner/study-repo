package domain;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface Graph {

	List<Node> getNodes();

	void setNodes(List<Node> nodes);

	List<List<Float>> getAdjacencyMatrix();

	void setAdjacencyMatrix(List<List<Float>> adjacencyMatrix);

	int getNodesCount();

	List<Edge> getMst();

	void setMst(List<Edge> mst);

	void updateNodesCount();

	void addNode(Node node);

	void addEdge(String origin, String destiny, Float weight);

	String calculateMst(Node node);

	String calculateShortestPathBetween(String node1, String node2);

	String calculateMstShortestPathBetween(String node1, String node2);

}
