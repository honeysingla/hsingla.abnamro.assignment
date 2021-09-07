export class Recipe {
  id: string;
  name: string;
  created: Date;
  vegan: boolean
  servings: number
  ingredients: string[] = [];
  instructions: string;
}
