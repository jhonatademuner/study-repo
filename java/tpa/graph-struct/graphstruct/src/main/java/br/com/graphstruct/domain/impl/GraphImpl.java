package br.com.graphstruct.domain.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.graphstruct.domain.Graph;
import br.com.graphstruct.domain.Node;

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
	public void calculateMst(Node node) {
		// TODO fazer ele retornar uma lista contendo a conexao otima
		List<Integer> optimum = new ArrayList<>();
		List<Float> key = new ArrayList<>(Collections.nCopies(nodesCount, Float.MAX_VALUE));
		List<Boolean> visited = new ArrayList<>(Collections.nCopies(nodesCount, false));

		key.set(getNodeIndex(node), 0f);
		optimum.add(-1);

		for (int i = 0; i < nodesCount - 1; i++) {
			int u = minKey(key, visited);
			visited.set(u, true);

			for (int v = 0; v < nodesCount; v++) {
				if (adjacencyMatrix.get(u).get(v) != 0 && !visited.get(v) && adjacencyMatrix.get(u).get(v) < key.get(v)) {
					optimum.set(v, u);
					key.set(v, adjacencyMatrix.get(u).get(v));
				}
			}
		}

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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'calculateShortestPathBetween'");
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
