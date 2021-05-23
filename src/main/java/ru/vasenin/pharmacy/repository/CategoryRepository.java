package ru.vasenin.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasenin.pharmacy.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
