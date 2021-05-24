package ru.vasenin.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.vasenin.pharmacy.domain.Drug;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {

    List<Drug> findByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCase(String title, String description);

    @Query("select d from Drug d where d.title = :title")
    List<Drug> find(String title);
}
