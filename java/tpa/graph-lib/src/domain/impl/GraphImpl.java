package domain.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.City;
import domain.Edge;
import domain.Graph;
import domain.Node;

@SuppressWarnings("rawtypes")
public class GraphImpl implements Graph {

	private List<Node> nodes = new ArrayList<Node>();
	private List<List<Float>> adjacencyMatrix = new ArrayList<List<Float>>();
	private int nodesCount = 0;
	private List<Edge> mst = new ArrayList<Edge>();

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
	public List<Edge> getMst() {
		return mst;
	}

	@Override
	public void setMst(List<Edge> mst) {
		this.mst = mst;
	}

	@Override
	public void addNode(Node node) {
		nodes.add(node);
		updateNodesCount();
		updateAdjacencyMatrix();
	}

	@Override
	public void updateNodesCount() {
		this.nodesCount = this.nodes.size();
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
	public String calculateMst(Node node) {
		List<Float> weights = new ArrayList<>(Collections.nCopies(nodesCount, Float.MAX_VALUE));
		List<Node> visited = new ArrayList<>();
		List<Edge> edges = new ArrayList<Edge>();

		visited.add(node);

		Edge minPathEdge;

		while (visited.size() < nodesCount) {
			minPathEdge = getVisitedNodesMinimunPath(visited);
			weights.set(getNodeIndex(minPathEdge.getDestination()), minPathEdge.getWeight());
			visited.add(minPathEdge.getDestination());
			edges.add(minPathEdge);
		}

		this.mst = edges;

		return formatMstString(edges);
	}

	private String formatMstString(List<Edge> edges) {
		String buffer = "";
		float totalWeight = 0;
		for (Edge edge : edges) {
			buffer += edge.getOrigin().getValue() + " - " + edge.getDestination().getValue() + " : " + edge.getWeight();
			totalWeight += edge.getWeight();
			buffer += "\n";
		}
		buffer += "Total weight: " + totalWeight;
		return buffer;
	}

	private Edge getVisitedNodesMinimunPath(List<Node> visitedNodes) {
		List<Float> nodesWeights = new ArrayList<Float>();
		List<Node> nodes = new ArrayList<Node>();
		for (Node node : visitedNodes) {
			List<Float> rowWeights = adjacencyMatrix.get(getNodeIndex(node));
			for (int i = 0; i < rowWeights.size(); i++) {
				if (rowWeights.get(i) > 0 && !visitedNodes.contains(this.getNodes().get(i))) {
					nodesWeights.add(rowWeights.get(i));
					nodes.add(this.getNodes().get(i));
				}
			}
		}
		float minWeight = Collections.min(nodesWeights);
		return getEdgeFromWeight(minWeight, visitedNodes);
	}

	private Edge getEdgeFromWeight(float weight, List<Node> visitedNodes) {
		for (int row = 0; row < adjacencyMatrix.size(); row++) {
			for (int column = 0; column < adjacencyMatrix.get(row).size(); column++) {
				Node rowNode = this.getNodes().get(row);
				Node columnNode = this.getNodes().get(column);
				if (adjacencyMatrix.get(row).get(column) == weight && visitedNodes.contains(rowNode)) {
					Edge edge = new EdgeImpl();
					edge.setOrigin(rowNode);
					edge.setDestination(columnNode);
					edge.setWeight(weight);
					return edge;
				}
			}
		}
		return null;
	}

	@Override
	public String calculateShortestPathBetween(String origin, String destination) {

		Node originNode = getNodeByValue(origin);
		Node destinationNode = getNodeByValue(destination);

		Map<Integer, Float> nodesDistance = dijkstraAlgorithm(originNode);

		return "shortest path between " + origin + " and " + destination + " is "
				+ nodesDistance.get(getNodeIndex(destinationNode));
	}

	private Map<Integer, Float> dijkstraAlgorithm(Map<Integer, Float> nodesDistance, Node originNode) {
		List<Node> visited = new ArrayList<>();
		List<Node> toBeVisited = new ArrayList<>();

		toBeVisited.add(originNode);

		while (!toBeVisited.isEmpty()) {
			Node currentNode = getLowestPathNode(toBeVisited, visited.isEmpty() ? originNode : visited.getLast());
			toBeVisited.remove(currentNode);
			int currentNodeIndex = getNodeIndex(currentNode);
			for (Node adjacentNode : this.getNodes()) {
				int adjacentNodeIndex = getNodeIndex(adjacentNode);
				if (adjacentNode != currentNode & this.getAdjacencyMatrix().get(currentNodeIndex).get(adjacentNodeIndex) != 0
						& !visited.contains(adjacentNode)) {
					toBeVisited.add(adjacentNode);
					float distance = this.getAdjacencyMatrix().get(currentNodeIndex).get(adjacentNodeIndex)
							+ nodesDistance.getOrDefault(currentNodeIndex, 0f);
					nodesDistance.put(adjacentNodeIndex, distance);
				}
			}
			visited.add(currentNode);
		}

		return nodesDistance;
	}

	private Map<Integer, Float> dijkstraAlgorithm(Node originNode) {
		return this.dijkstraAlgorithm(new HashMap<>(), originNode);
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
	public String calculateMstShortestPathBetween(String origin, String destination) {
		String warning = "";
		if (this.mst.isEmpty()) {
			warning = "MST not calculated yet. Calculating MST now...\n";
			calculateMst(this.getNodeByValue(origin));
		}

		Map<Integer, Float> mstMap = new HashMap<>();
		for (Edge edge : this.mst) {
			mstMap.put(getNodeIndex(edge.getDestination()), edge.getWeight());
		}
		Map<Integer, Float> nodesDistance = dijkstraAlgorithm(mstMap, this.getNodeByValue(origin));
		return warning + "\nShortest path between " + origin + " and " + destination + " is "
				+ nodesDistance.get(getNodeIndex(getNodeByValue(destination)));
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
