package domain.impl;

import domain.City;

public class CityImpl implements City {

	private String name;

	public CityImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "CityImpl [name=" + name + "]";
	}

}
