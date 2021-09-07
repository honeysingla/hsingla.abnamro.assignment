package com.hsingla.assignment.abnamrorecipesbe.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsingla.assignment.abnamrorecipesbe.model.Recipe;
import com.hsingla.assignment.abnamrorecipesbe.repository.RecipeRepository;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RecipeController {

	@Autowired
	RecipeRepository recipeRepository;

	@GetMapping("/allRecipes")
	public ResponseEntity<List<Recipe>> getAllRecipes(@RequestParam(required = false) String name) {
		try {
			List<Recipe> recipes = new ArrayList<Recipe>();

			if (name == null)
				recipeRepository.findAll().forEach(recipes::add);
			else
				recipeRepository.findByNameContaining(name).forEach(recipes::add);

			if (recipes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(recipes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/recipe/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") String id) {
		Optional<Recipe> recipeData = recipeRepository.findById(id);

		if (recipeData.isPresent()) {
			return new ResponseEntity<>(recipeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/recipe")
	public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
		try {
			if(recipeRepository.findById(recipe.getId()).isEmpty())
			{
			    recipe.setCreated(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()));
			    recipe.setUpdated(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()));
				Recipe createRecipe = recipeRepository.save(recipe);
				return new ResponseEntity<>(createRecipe, HttpStatus.CREATED);
			}else
			{
				return new ResponseEntity<>(null, HttpStatus.FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/recipe/{id}")
	public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") String id, @RequestBody Recipe recipe) {
		Optional<Recipe> recipeData = recipeRepository.findById(id);
		if (recipeData.isPresent()) {
			Recipe updateRecipe = recipeData.get();
			updateRecipe.setName(recipe.getName());
			updateRecipe.setCreated(recipeData.get().getCreated());
			updateRecipe.setUpdated(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()));
			updateRecipe.setIngredients(recipe.getIngredients());
			updateRecipe.setInstructions(recipe.getInstructions());
			updateRecipe.setServings(recipe.getServings());
			return new ResponseEntity<>(recipeRepository.save(updateRecipe), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/recipe/{id}")
	public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") String id) {
		Optional<Recipe> recipeData = recipeRepository.findById(id);
		System.out.println(recipeData.get().getId());
		try {
			if(recipeData.get().getId()!=null)
			{
				recipeRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/recipes")
	public ResponseEntity<HttpStatus> deleteAllRecipes() {
		try {
			recipeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	

}
