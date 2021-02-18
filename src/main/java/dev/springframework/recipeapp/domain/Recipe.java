package dev.springframework.recipeapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {

  @Id                                                   // Auto generating field

  @GeneratedValue(strategy = GenerationType.IDENTITY)   // Identity is going to leverage the
                                                        // underlying persistence framework
                                                        // to generate an ID value. Identity is a
                                                        // special type to relational databases
                                                        // that will support automatic generation
                                                        // of a sequence. So MySQL does have an
                                                        // auto-generated primary key property
                                                        // that we can use as well as several
                                                        // other databases do.
  private Long id;

  private String description;
  private Integer prepTime;
  private Integer cookTime;
  private Integer servings;
  private String source;
  private String url;

  @Lob
  private String directions;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")  // Now we want the recipe to own
                                                              // this. So now we want to add in a
                                                              // cascade type and it'll persist all
                                                              // operations. Also add a mappedBy,
                                                              // and in this case we want to say
                                                              // the property on the child class.
                                                              // So that's going to be "recipe".
  private Set<Ingredient> ingredients = new HashSet<>();

  @Lob
  private Byte[] image;

  @OneToOne(cascade = CascadeType.ALL)       // Recipe is going to be the owner of this and
                                             // persist. Fo, if we delete a Recipe, that is going
                                             // to persist down and delete Notes. Whereas on the
                                             // Notes object or the Notes entity, we are not
                                             // specifying a cascade operation there. So if we
                                             // delete the Notes object, the Recipe will remain
                                             // inside the database.


                     // MappedBy is the target property on the Ingredient class.

  private Notes notes;

  @Enumerated(value = EnumType.STRING)
  private Difficulty difficulty;

  @ManyToMany
  @JoinTable(name = "recipe_category",
      joinColumns = @JoinColumn(name = "recipe_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<Category> categories = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrepTime() {
    return prepTime;
  }

  public void setPrepTime(Integer prepTime) {
    this.prepTime = prepTime;
  }

  public Integer getCookTime() {
    return cookTime;
  }

  public void setCookTime(Integer cookTime) {
    this.cookTime = cookTime;
  }

  public Integer getServings() {
    return servings;
  }

  public void setServings(Integer servings) {
    this.servings = servings;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDirections() {
    return directions;
  }

  public void setDirections(String directions) {
    this.directions = directions;
  }

  public Byte[] getImage() {
    return image;
  }

  public void setImage(Byte[] image) {
    this.image = image;
  }

  public Notes getNotes() {
    return notes;
  }

  public void setNotes(Notes notes) {
    this.notes = notes;
  }

  public Set<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Difficulty difficulty) {
    this.difficulty = difficulty;
  }

  public Set<Category> getCategories() {
    return categories;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }
}
