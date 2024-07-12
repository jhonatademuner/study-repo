package domain.impl;

import domain.Edge;
import domain.Node;

@SuppressWarnings("rawtypes")
public class EdgeImpl implements Edge {

	private Node source;
	private Node destiny;
	private float weight;

	public EdgeImpl(Node source, Node destiny, float weight) {
		this.source = source;
		this.destiny = destiny;
		this.weight = weight;
	}

	@Override
	public Node getSource() {
		return source;
	}

	@Override
	public void setSource(Node source) {
		this.source = source;
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
	public float getWeight() {
		return weight;
	}

	@Override
	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "EdgeImpl [origin=" + source + ", destiny=" + destiny + ", weight=" + weight + "]";
	}

}
