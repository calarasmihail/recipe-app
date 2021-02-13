package dev.springframework.recipeapp.controllers;

import dev.springframework.recipeapp.domain.Category;
import dev.springframework.recipeapp.domain.UnitOfMeasure;
import dev.springframework.recipeapp.repositories.CategoryRepository;
import dev.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  private CategoryRepository categoryRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;

  public IndexController(
      CategoryRepository categoryRepository,
      UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @RequestMapping({"", "/", "/index"})
  public String getIndexPage() {

    Optional<Category> categoryOptional = categoryRepository.findByDescription("American");

    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

    System.out.println("Cat ID is: " + categoryOptional.get().getId());
    System.out.println("UOM ID is: " + uomOptional.get().getId());

    return "index";
  }

}
