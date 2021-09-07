import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from "../../model/recipe";
import {RecipesService} from "../../service/recipes.service";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-recipes',
  templateUrl: './recipe-read.component.html',
  styleUrls: ['./recipe-read.component.scss']
})
export class RecipeReadComponent implements OnInit {

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

  deleteRecipe(id: string): void {
    this.service.deleteRecipe(id).subscribe(() => this.location.back())
  }

  back(): void {
    this.location.back();
  }

}
