package ru.vasenin.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasenin.pharmacy.domain.Drug;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Long> {
    List<Drug> findByTitleContaining(String pattern);
    List<Drug> findByTitleContainingAndDescriptionContaining(String title,
                                                   String description);
}
