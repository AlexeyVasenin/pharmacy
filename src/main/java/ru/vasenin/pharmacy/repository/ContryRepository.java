package ru.vasenin.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasenin.pharmacy.domain.Country;

public interface ContryRepository extends JpaRepository<Country, Long> {
}
