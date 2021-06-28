package dev.springframework.recipeapp.services;

import dev.springframework.recipeapp.domain.Recipe;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
