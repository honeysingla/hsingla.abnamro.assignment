import {Component, OnInit} from '@angular/core';
import {Recipe} from "../../model/recipe";
import {RecipesService} from "../../service/recipes.service";

@Component({
  selector: 'app-recipes',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {

  recipes: Recipe[] = [];

  constructor(private service: RecipesService) {
  }

  ngOnInit(): void {
    this.getRecipes()
  }

  getRecipes(): void {
    this.service.getRecipes().subscribe(recipes => this.recipes = recipes)
  }

}
