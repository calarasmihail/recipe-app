package dev.springframework.recipeapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne                      // In this case we don't need to specify a cascade because this
                                 // instance we are going to allow the Recipe to own this. If we
                                 // delete the Notes object, we don't want go back and delete the
                                 // Recipe object. So we don't want cascade operations happening
                                 // but the inverse, if we want to delete a Recipe, of course we
                                 // want to delete the recipeNotes.
  private Recipe recipe;

  @Lob                           // @Lob annotation is for large objects
  private String recipeNotes;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public String getRecipeNotes() {
    return recipeNotes;
  }

  public void setRecipeNotes(String recipeNotes) {
    this.recipeNotes = recipeNotes;
  }
}
