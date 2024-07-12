package domain;

@SuppressWarnings("rawtypes")
public interface Edge {

	Node getSource();

	void setSource(Node origin);

	Node getDestiny();

	void setDestiny(Node destiny);

	float getWeight();

	void setWeight(float weight);

}
