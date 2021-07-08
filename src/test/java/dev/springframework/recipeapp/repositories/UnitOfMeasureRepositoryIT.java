package dev.springframework.recipeapp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.springframework.recipeapp.domain.UnitOfMeasure;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
class UnitOfMeasureRepositoryIT {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @BeforeEach
  void setUp() {
  }

  @Test
  void findByDescription() {
    Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    assertEquals("Teaspoon", unitOfMeasureOptional.get().getDescription());
  }
}