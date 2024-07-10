package br.com.graphstruct.domain;

@SuppressWarnings("rawtypes")
public interface Edge {

	Node getOrigin();

	void setOrigin(Node origin);

	Node getDestiny();

	void setDestiny(Node destiny);

	int getWeight();

	void setWeight(int weight);

}
