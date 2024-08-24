package domain;

public interface Edge<T> {

	Node<T> getOrigin();

	void setOrigin(Node<T> origin);

	Node<T> getDestination();

	void setDestination(Node<T> destiny);

	float getWeight();

	void setWeight(float weight);

}
