package domain.impl;

import domain.Edge;
import domain.Node;

public class EdgeImpl<T> implements Edge<T> {

	private Node<T> origin;
	private Node<T> destination;
	private float weight;

	public EdgeImpl() {
	}
	
	public EdgeImpl(Node<T> origin, Node<T> destination, float weight) {
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
	}

	@Override
	public Node<T> getOrigin() {
		return origin;
	}

	@Override
	public void setOrigin(Node<T> origin) {
		this.origin = origin;
	}

	@Override
	public Node<T> getDestination() {
		return destination;
	}

	@Override
	public void setDestination(Node<T> destination) {
		this.destination = destination;
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
		return this.origin + " --> " + this.destination + " (" + this.weight + ")";
	}

}
