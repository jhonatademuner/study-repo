package br.com.graphstruct.domain.impl;

import br.com.graphstruct.domain.Edge;
import br.com.graphstruct.domain.Node;

@SuppressWarnings("rawtypes")
public class EdgeImpl implements Edge {

	private Node origin;
	private Node destiny;
	private int weight;

	@Override
	public Node getOrigin() {
		return origin;
	}

	@Override
	public void setOrigin(Node origin) {
		this.origin = origin;
	}

	@Override
	public Node getDestiny() {
		return destiny;
	}

	@Override
	public void setDestiny(Node destiny) {
		this.destiny = destiny;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "EdgeImpl [origin=" + origin + ", destiny=" + destiny + ", weight=" + weight + "]";
	}

}
