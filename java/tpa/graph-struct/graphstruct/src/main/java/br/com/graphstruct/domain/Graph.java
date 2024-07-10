package br.com.graphstruct.domain;

import java.util.Set;
import java.util.List;

@SuppressWarnings("rawtypes")
public interface Graph {

	Set<Node> getNodes();

	void setNodes(Set<Node> nodes);

	List<List<Float>> getAdjacencyMatrix();

	void setAdjacencyMatrix(List<List<Float>> adjacencyMatrix);

	int getNodesCount();

	void addNode(Node node);

	void addEdge(Node origin, Node destiny, Float weight);

	List<Node> calculateMst(Node node);

	void calculateShortestPathBetween(Node node1, Node node2);

	void calculateMstShortestPathBetween(Node node);

}
