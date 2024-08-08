package domain.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.City;
import domain.Graph;
import domain.Node;

@SuppressWarnings("rawtypes")
public class GraphImpl implements Graph {

	private List<Node> nodes = new ArrayList<Node>();
	private List<List<Float>> adjacencyMatrix = new ArrayList<List<Float>>();
	private int nodesCount = 0;

	public GraphImpl() {
	}

	@Override
	public List<Node> getNodes() {
		return nodes;
	}

	@Override
	public void setNodes(List<Node> nodes) {
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
	public void addEdge(String origin, String destination, Float weight) {

		Node originNode = getNodeByValue(origin);
		Node destinationNode = getNodeByValue(destination);
		adjacencyMatrix.get(getNodeIndex(originNode)).set(getNodeIndex(destinationNode), weight);
	}

	private Node getNodeByValue(String name) {
		for (Node<City> node : nodes) {
			if (node.getValue().getName().equals(name)) {
				return node;
			}
		}
		throw new IllegalArgumentException("Node not found");
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
			System.out.println(optimum.get(i) + " - " + nodes.toArray(new Node[nodes.size()])[i] + "\t"
					+ key.get(getNodeIndex(optimum.get(i))));
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
	public String calculateShortestPathBetween(String origin, String destination) {

		Node originNode = getNodeByValue(origin);
		Node destinationNode = getNodeByValue(destination);

		Map<Integer, Float> nodesDistance = new HashMap<>();
		List<Node> visited = new ArrayList<>();
		List<Node> toBeVisited = new ArrayList<>();

		toBeVisited.add(originNode);

		while (!toBeVisited.isEmpty()) { // if tobevisited is not empty check every node in tobevisited until is empty
			Node currentNode = getLowestPathNode(toBeVisited, visited.isEmpty() ? originNode : visited.getLast()); // return shortest path
			toBeVisited.remove(currentNode);
			int currentNodeIndex = getNodeIndex(currentNode);
			for (Node adjacentNode : this.getNodes()) { // iterate every adjacent node of current node
				int adjacentNodeIndex = getNodeIndex(adjacentNode);
				if (adjacentNode != currentNode & this.getAdjacencyMatrix().get(currentNodeIndex).get(adjacentNodeIndex) != 0
						& !visited.contains(adjacentNode)) {
					toBeVisited.add(adjacentNode);
					float distance = this.getAdjacencyMatrix().get(currentNodeIndex).get(adjacentNodeIndex) + nodesDistance.getOrDefault(currentNodeIndex, 0f);
					nodesDistance.put(adjacentNodeIndex, distance);
				}
			}
			visited.add(currentNode);

		}

		return "shortest path between " + origin + " and " + destination + " is " + nodesDistance.get(getNodeIndex(destinationNode));

	}

	private Node getLowestPathNode(List<Node> toBeVisited, Node originNode) {
		Node lowestPathNode = toBeVisited.get(0);
		float lowestPath = Float.MAX_VALUE;
		int originNodeIndex = getNodeIndex(originNode);
		for (Node node : toBeVisited) {
			int nodeIndex = getNodeIndex(node);
			float nodePath = adjacencyMatrix.get(originNodeIndex).get(nodeIndex);
			if (nodePath < lowestPath) {
				lowestPath = nodePath;
				lowestPathNode = node;
			}
		}
		return lowestPathNode;
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
