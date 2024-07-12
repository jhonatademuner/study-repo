package domain.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Graph;
import domain.Node;

@SuppressWarnings("rawtypes")
public class GraphImpl implements Graph {

	private Set<Node> nodes = new HashSet<Node>();
	private List<List<Float>> adjacencyMatrix = new ArrayList<List<Float>>();
	private int nodesCount = 0;

	public GraphImpl() {
	}

	@Override
	public Set<Node> getNodes() {
		return nodes;
	}

	@Override
	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	public List<List<Float>> getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	@Override
	public void setAdjacencyMatrix(List<List<Float>> adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	@Override
	public int getNodesCount() {
		return nodesCount;
	}

	@Override
	public void addNode(Node node) {
		nodes.add(node);
		updateNodesCount();
		updateAdjacencyMatrix();
	}

	private void updateNodesCount() {
		this.nodesCount = nodes.size();
	}

	// TODO: if necessary, add node removal bahavior
	private void updateAdjacencyMatrix() {
		for (int i = 0; i < nodesCount; i++) {
			if (i >= adjacencyMatrix.size()) {
				adjacencyMatrix.add(new ArrayList<>(Collections.nCopies(nodesCount, 0f)));
			} else {
				List<Float> row = adjacencyMatrix.get(i);
				if (row.size() < nodesCount) {
					row.addAll(Collections.nCopies(nodesCount - row.size(), 0f));
				}
			}
		}
	}

	@Override
	public void addEdge(Node origin, Node destination, Float weight) {
		adjacencyMatrix.get(getNodeIndex(origin)).set(getNodeIndex(destination), weight);
	}

	@Override
	public List<Node> calculateMst(Node node) {
		List<Node> optimum = new ArrayList<>();
		List<Float> key = new ArrayList<>(Collections.nCopies(nodesCount, Float.MAX_VALUE));
		List<Boolean> visited = new ArrayList<>(Collections.nCopies(nodesCount, false));

		key.set(getNodeIndex(node), 0f);

		for (int i = 0; i < nodesCount - 1; i++) {
			int u = minKey(key, visited); 
			visited.set(u, true); 

			for (int v = 0; v < nodesCount; v++) {
				if (adjacencyMatrix.get(u).get(v) != 0 && !visited.get(v) && adjacencyMatrix.get(u).get(v) < key.get(v)) { 
					optimum.set(v, this.nodes.toArray(new Node[nodes.size()])[v]);
				}
			}
		}

		System.out.println("Edge \tWeight");
		for (int i = 1; i < nodesCount; i++) {
			System.out.println(optimum.get(i) + " - " + nodes.toArray(new Node[nodes.size()])[i] + "\t" + key.get(getNodeIndex(optimum.get(i))));
		}



		return optimum;
	}

	private int minKey(List<Float> key, List<Boolean> mstSet) {
		float min = Float.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < nodesCount; i++) {
			if (!mstSet.get(i) && key.get(i) < min) {
				min = key.get(i);
				minIndex = i;
			}
		}

		return minIndex;
	}

	@Override
	public void calculateShortestPathBetween(Node node1, Node node2) {
		float weight = 0f;
		List<Node> visited = new ArrayList<>();
		List<Node> toBeVisited = new ArrayList<>();

		toBeVisited.add(node1);

		while(!toBeVisited.isEmpty()) { //if tobevisited is not empty check every node in tobevisited until is empty
			Node currentNode = GetLowestPathNode(toBeVisited); //return shortest path
			toBeVisited.remove(currentNode);
			for(float adjacentNode : adjacencyMatrix.get(currentNode)) //iterate every adjacent node of current node
				if(!visited.contains(adjacentNode)){ 
					toBeVisited.add(adjacentNode);
				}
				
			visited.add(currentNode);

		}

		System.out.println("shortest path between " + node1 + " and " + node2 + " is " + weight);

		return;
	}

	@Override
	public void calculateMstShortestPathBetween(Node node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'calculateMstShortestPathBetween'");
	}

	private int getNodeIndex(Node node) {
		int i = 0;
		for (Node n : nodes) {
			if (n.equals(node)) {
				return i;
			}
			i++;
		}
		throw new IllegalArgumentException("Node not found");
	}

}
