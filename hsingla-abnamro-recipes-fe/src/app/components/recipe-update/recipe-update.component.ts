import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from "../../model/recipe";
import {RecipesService} from "../../service/recipes.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-recipe-update',
  templateUrl: './recipe-update.component.html',
  styleUrls: ['./recipe-update.component.scss']
})
export class RecipeUpdateComponent implements OnInit {

  @Input() recipe: Recipe;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private service: RecipesService) {
  }

  ngOnInit(): void {
    this.getRecipe()
  }

  getRecipe(): void {
    const id = this.route.snapshot.paramMap.get('id')

    this.service.getRecipe(id).subscribe(recipe => this.recipe = recipe)
  }

  updateRecipe(): void {
    this.service.updateRecipe(this.recipe).subscribe(() => this.back())
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
