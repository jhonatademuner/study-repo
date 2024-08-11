package domain.impl;

import domain.Edge;
import domain.Node;

@SuppressWarnings("rawtypes")
public class EdgeImpl implements Edge {

	private Node origin;
	private Node destination;
	private float weight;

	public EdgeImpl() {
	}
	
	public EdgeImpl(Node origin, Node destination, float weight) {
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
	}

	public Node getOrigin() {
		return origin;
	}

	public void setOrigin(Node origin) {
		this.origin = origin;
	}

	public Node getDestination() {
		return destination;
	}

	public void setDestination(Node destination) {
		this.destination = destination;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "EdgeImpl [origin=" + origin + ", destination=" + destination + ", weight=" + weight + "]";
	}

}
