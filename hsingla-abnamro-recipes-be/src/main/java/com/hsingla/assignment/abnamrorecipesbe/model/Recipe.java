package com.hsingla.assignment.abnamrorecipesbe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipe")
public class Recipe {

	@Id
	private String id;
	private String name;
	private String created;
	private String updated;
	private boolean vegatrian;
	private List<String> ingredients;
    private int servings;
    private String instructions;
    
    public Recipe() {};

    public Recipe(String name) {
        this.name = name;
    }

	public Recipe(String id, String name, String created, String updated, boolean vegatrian, List<String> ingredients,
			int servings, String instructions) {
		super();
		this.id = id;
		this.name = name;
		this.created = created;
		this.updated = updated;
		this.vegatrian = vegatrian;
		this.ingredients = ingredients;
		this.servings = servings;
		this.instructions = instructions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public boolean isVegatrian() {
		return vegatrian;
	}

	public void setVegatrian(boolean vegatrian) {
		this.vegatrian = vegatrian;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", created=" + created + ", updated=" + updated + ", vegatrian="
				+ vegatrian + ", ingredients=" + ingredients + ", servings=" + servings + ", instructions="
				+ instructions + "]";
	}
    	
}
