package domain;

@SuppressWarnings("rawtypes")
public interface Edge {

	Node getOrigin();

	void setOrigin(Node origin);

	Node getDestination();

	void setDestination(Node destiny);

	float getWeight();

	void setWeight(float weight);

}
