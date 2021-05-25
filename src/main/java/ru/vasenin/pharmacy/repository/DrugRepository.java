package ru.vasenin.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vasenin.pharmacy.domain.Country;
import ru.vasenin.pharmacy.domain.Drug;
import ru.vasenin.pharmacy.domain.Ingredient;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {

    List<Drug> findByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCase(String title, String description);

    @Query("select d from Drug d join d.category c where c.title like :title")
    List<Drug> sortCategory(@Param("title") String title);

    @Query("select c from Country c")
    List<Country> allCountry();

    @Query("select i from Ingredient i")
    List<Ingredient> allIngredients();
}
