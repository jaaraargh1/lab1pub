package item;

import java.util.ArrayList;

public class Item {

	private Double weight;
	private String name;
	private String description;

	public Item(String name, String description, Double weight) {
		this.description = description;
		this.name = name;
		this.weight = weight;
		
	}

	public void printItemInfo() {

		System.out.println(this.getName() + this.getDescription() + this.getWeight());

	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	

}
