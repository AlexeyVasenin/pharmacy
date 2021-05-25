package ru.vasenin.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vasenin.pharmacy.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
