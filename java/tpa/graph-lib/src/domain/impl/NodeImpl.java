package domain.impl;

import domain.Node;

public class NodeImpl<T> implements Node<T> {

	private T value;

	public NodeImpl(T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

}
