import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {RecipeListComponent} from "./components/recipe-list/recipe-list.component";
import {RecipeCreateComponent} from "./components/recipe-create/recipe-create.component";
import {RecipeUpdateComponent} from "./components/recipe-update/recipe-update.component";
import {RecipeReadComponent} from "./components/recipe-read/recipe-read.component";

const routes: Routes = [
  {path: '', component: RecipeListComponent},
  {path: 'recipes', component: RecipeListComponent},
  {path: 'recipes/create', component: RecipeCreateComponent},
  {path: 'recipes/update/:id', component: RecipeUpdateComponent},
  {path: 'recipes/read/:id', component: RecipeReadComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
