package ru.vasenin.pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vasenin.pharmacy.domain.Country;
import ru.vasenin.pharmacy.domain.SimpleResult;
import ru.vasenin.pharmacy.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public SimpleResult<List<Country>> getAll(){
        return new SimpleResult<>(countryService.getAll());
    }


}
