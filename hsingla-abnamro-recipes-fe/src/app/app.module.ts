import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RecipeListComponent} from './components/recipe-list/recipe-list.component';
import {RecipeCreateComponent} from './components/recipe-create/recipe-create.component';
import {RecipeUpdateComponent} from './components/recipe-update/recipe-update.component';
import {RecipeReadComponent} from "./components/recipe-read/recipe-read.component";

import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    RecipeListComponent,
    RecipeCreateComponent,
    RecipeUpdateComponent,
    RecipeReadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
