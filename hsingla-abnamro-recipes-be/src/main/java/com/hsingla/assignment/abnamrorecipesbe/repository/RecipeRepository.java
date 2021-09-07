package com.hsingla.assignment.abnamrorecipesbe.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hsingla.assignment.abnamrorecipesbe.model.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
	List<Recipe> findByNameContaining(String name);
}
