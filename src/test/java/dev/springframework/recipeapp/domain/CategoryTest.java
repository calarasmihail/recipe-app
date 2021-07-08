package dev.springframework.recipeapp.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

  Category category;

  @BeforeEach
  public void setUp() {
    category = new Category();
  }

  @Test
  void getId() {
    Long idvalue = 4L;
    category.setId(idvalue);
    assertEquals(idvalue, category.getId());
  }

  @Test
  void getDescription() {
  }

  @Test
  void getRecipes() {
  }
}