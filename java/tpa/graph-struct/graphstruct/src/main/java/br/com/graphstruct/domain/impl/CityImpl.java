package br.com.graphstruct.domain.impl;

import br.com.graphstruct.domain.City;

public class CityImpl implements City {

	private String name;
	private String state;
	private String country;
	private int population;

	public CityImpl(String name, String state, String country, int population) {
		this.name = name;
		this.state = state;
		this.country = country;
		this.population = population;
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
	public String getState() {
		return state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int getPopulation() {
		return population;
	}

	@Override
	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "CityImpl [name=" + name + ", state=" + state + ", country=" + country + ", population=" + population + "]";
	}

}
