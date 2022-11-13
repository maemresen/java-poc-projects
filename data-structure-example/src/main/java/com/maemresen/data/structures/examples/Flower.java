package com.maemresen.data.structures.examples;

public class Flower{


	private String name;
	private int petals;
	private float price;

	public Flower(String name, int petals, float price){

		this.name = name;
		this.petals = petals;
		this.price = price;

	}

	public void setName(String name){
		this.name = name;
	}

	public void setPetals(int petals){
		this.petals = petals;
	}

	public void setPrice(float price){
		this.price = price;
	}

}