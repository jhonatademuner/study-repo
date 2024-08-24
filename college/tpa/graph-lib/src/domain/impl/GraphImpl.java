package domain.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import domain.City;
import domain.Edge;
import domain.Graph;
import domain.Node;

public class GraphImpl<T> implements Graph<T> {

	private List<Node<T>> nodes = new ArrayList<Node<T>>();
	private List<List<Float>> adjacencyMatrix = new ArrayList<List<Float>>();
	private int nodesCount = 0;
	private Graph<T> mst = null;

	public GraphImpl() {
	}

	@Override
	public List<Node<T>> getNodes() {
		return nodes;
	}

	@Override
	public void setNodes(List<Node<T>> nodes) {
		this.nodes = nodes;
		this.updateNodesCount();
		this.updateAdjacencyMatrix();
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
	public Graph<T> getMst() {
		return mst;
	}

	@Override
	public void addNode(Node<T> node) {
		nodes.add(node);
		updateGraph();
	}

	@Override
	public void addEdge(String origin, String destination, Float weight) {
		Node<T> originNode = getNodeByValue(origin);
		Node<T> destinationNode = getNodeByValue(destination);
		adjacencyMatrix.get(getNodeIndex(originNode)).set(getNodeIndex(destinationNode), weight);
	}

	@Override
	public String calculateShortestPathBetween(String origin, String destination) {
		Node<T> originNode = getNodeByValue(origin);
		Node<T> destinationNode = getNodeByValue(destination);
		float shortestDistance = dijkstraAlgorithm(originNode, destinationNode);
		return "Shortest path between " + origin + " and " + destination + " is " + shortestDistance;
	}

	@Override
	public String calculateMst(Node<T> node) {
		List<Float> weights = new ArrayList<>(Collections.nCopies(this.nodesCount, Float.MAX_VALUE));
		List<Node<T>> visited = new ArrayList<>();
		Graph<T> mstGraph = new GraphImpl<T>();
		Edge<T> minPathEdge;

		mstGraph.setNodes(this.getNodes());
		visited.add(node);

		while (visited.size() < this.nodesCount) {
			minPathEdge = getVisitedNodesMinimunPath(visited);
			weights.set(getNodeIndex(minPathEdge.getDestination()), minPathEdge.getWeight());
			visited.add(minPathEdge.getDestination());
			mstGraph.addEdge(((City) minPathEdge.getOrigin().getValue()).getName(),
					((City) minPathEdge.getDestination().getValue()).getName(),
					minPathEdge.getWeight());
			mstGraph.addEdge(((City) minPathEdge.getDestination().getValue()).getName(),
					((City) minPathEdge.getOrigin().getValue()).getName(),
					minPathEdge.getWeight());
		}

		this.mst = mstGraph;
		return formatGraphString(mstGraph);
	}

	@Override
	public String calculateMstShortestPathBetween(String origin, String destination) {

		String warning = "";
		if (this.mst == null) {
			warning = "MST not calculated yet. Calculating MST now...\n";
			calculateMst(this.getNodeByValue(origin));
		}

		System.out.println(formatGraphString(this.mst));

		float shortestDistance = dijkstraAlgorithm(this.mst, getNodeByValue(origin), getNodeByValue(destination));
		return warning + "\nShortest path between " + origin + " and " + destination + " is " + shortestDistance;
	}

	@Override
	public String formatGraphString(Graph<T> graph) {
		String buffer = "";
		float totalWeight = 0;
		for (int i = 0; i < graph.getAdjacencyMatrix().size(); i++) {
			for (int j = 0; j < graph.getAdjacencyMatrix().get(i).size(); j++) {
				float weight = graph.getAdjacencyMatrix().get(i).get(j);
				if (weight > 0) {
					buffer += ((City) graph.getNodes().get(i).getValue()).getName() + " --> "
							+ ((City) graph.getNodes().get(j).getValue()).getName() + " ( " + weight + " )";
					totalWeight += weight;
					buffer += "\n";
				}
			}
		}
		buffer += "Total weight: " + totalWeight;
		return buffer;
	}

	private void updateGraph() {
		updateNodesCount();
		updateAdjacencyMatrix();
	}

	private void updateNodesCount() {
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

	private Node<T> getNodeByValue(String name) {
		for (Node<T> node : nodes) {
			if (((City) node.getValue()).getName().equals(name)) {
				return node;
			}
		}
		throw new IllegalArgumentException("Node not found");
	}

	private Edge<T> getVisitedNodesMinimunPath(List<Node<T>> visitedNodes) {
		List<Float> nodesWeights = new ArrayList<Float>();
		List<Node<T>> destinationNodes = new ArrayList<Node<T>>();
		List<Node<T>> originNodes = new ArrayList<Node<T>>();
		for (Node<T> node : visitedNodes) {
			List<Float> rowWeights = adjacencyMatrix.get(getNodeIndex(node));
			for (int i = 0; i < rowWeights.size(); i++) {
				if (rowWeights.get(i) > 0 && !visitedNodes.contains(this.getNodes().get(i))) {
					nodesWeights.add(rowWeights.get(i));
					originNodes.add(node);
					destinationNodes.add(this.getNodes().get(i));
				}
			}
		}
		float minWeight = Collections.min(nodesWeights);
		int minWeightIndex = nodesWeights.indexOf(minWeight);
		return new EdgeImpl<T>(originNodes.get(minWeightIndex), destinationNodes.get(minWeightIndex), minWeight);
	}

	private float dijkstraAlgorithm(Node<T> originNode, Node<T> destinationNode) {
		return dijkstraAlgorithm(this, originNode, destinationNode);
	}

	private float dijkstraAlgorithm(Graph<T> matrix, Node<T> originNode, Node<T> destinationNode) {
		Map<Node<T>, Float> distances = new HashMap<>();
		Map<Node<T>, Node<T>> previousNodes = new HashMap<>();
		PriorityQueue<Node<T>> priorityQueue = new PriorityQueue<>(
				matrix.getNodesCount(),
				(n1, n2) -> Float.compare(distances.get(n1), distances.get(n2)));

		for (Node<T> node : matrix.getNodes()) { // O(N)
			distances.put(node, Float.MAX_VALUE);
			previousNodes.put(node, null);
		}
		distances.put(originNode, 0f);
		priorityQueue.add(originNode); // O(log N) for adding the initial node

		while (!priorityQueue.isEmpty()) { // O(N)
			Node<T> currentNode = priorityQueue.poll(); // O(log N)
			int currentIndex = getNodeIndex(currentNode); // O(N)
			List<Float> neighbors = matrix.getAdjacencyMatrix().get(currentIndex);

			for (int i = 0; i < neighbors.size(); i++) { // O(N)
				Float weight = neighbors.get(i);
				if (weight > 0) {
					Node<T> adjacentNode = matrix.getNodes().get(i);
					float newDist = distances.get(currentNode) + weight;
					if (newDist < distances.get(adjacentNode)) {
						distances.put(adjacentNode, newDist);
						previousNodes.put(adjacentNode, currentNode);
						priorityQueue.add(adjacentNode); // O(log N) for adding the updated node
					}
				}
			}
		}

		return distances.get(destinationNode);
	}

	private int getNodeIndex(Node<T> node) {
		return this.nodes.indexOf(node);
	}

}
