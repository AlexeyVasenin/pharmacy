package ru.vasenin.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasenin.pharmacy.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
