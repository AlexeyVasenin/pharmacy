package ru.vasenin.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vasenin.pharmacy.domain.Country;
import ru.vasenin.pharmacy.repository.ContryRepository;

import java.util.List;

@Service
public class CountryService {

    private final ContryRepository contryRepository;

    @Autowired
    public CountryService(ContryRepository contryRepository) {
        this.contryRepository = contryRepository;
    }

    public List<Country> getAll() {
        return contryRepository.findAll();
    }
}
