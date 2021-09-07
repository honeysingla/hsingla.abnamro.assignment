import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from "../../model/recipe";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {RecipesService} from "../../service/recipes.service";

@Component({
  selector: 'app-recipe-create',
  templateUrl: './recipe-create.component.html',
  styleUrls: ['./recipe-create.component.scss']
})
export class RecipeCreateComponent implements OnInit {

  recipe: Recipe;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private service: RecipesService) {
  }

  ngOnInit(): void {
    this.recipe = new Recipe();
  }

  createRecipe(): void {
    this.service.createRecipe(this.recipe).subscribe(() => this.back())
  }

  addIngredient(ingredient: string): void {
    if (!ingredient) {
      return;
    }

    this.recipe.ingredients.push(ingredient)
  }

  removeIngredient(ingredient: string): void {
    const index: number = this.recipe.ingredients.indexOf(ingredient);

    if (index !== -1) {
      this.recipe.ingredients.splice(index, 1);
    }
  }

  back(): void {
    this.location.back();
  }

}
