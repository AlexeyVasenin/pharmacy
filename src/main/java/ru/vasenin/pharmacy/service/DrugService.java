package ru.vasenin.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.vasenin.pharmacy.controllers.DrugController;
import ru.vasenin.pharmacy.domain.Drug;
import ru.vasenin.pharmacy.domain.SimpleDrug;
import ru.vasenin.pharmacy.repository.DrugRepository;

import java.util.List;


@Service
public class DrugService {

    private final DrugRepository drugRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }


    public List<Drug> getAll() {
        return drugRepository.findAll();

    }

    public Drug getOne(long id) {
        return drugRepository.findById(id).orElseGet(() -> null);
    }

    public Drug save(DrugController.SaveDrugReqt reqt) {
        Drug drug = new Drug();
        drug.setTitle(reqt.getTitle());
        drug.setDescription(reqt.getDescription());
        drug.setCountryId(reqt.getCountryId());
        drug.setCategoryId(reqt.getCategoryId());

        return update(drug);
    }


    public Drug update(Drug drug) {
        return drugRepository.save(drug);
    }


    public List<Drug> sortByTitle(String title) {
        return drugRepository.findByTitleContaining(title);
    }

    public Page<Drug> getPage(int page) {
        return drugRepository.findAll(PageRequest.of(page, 5));
    }
}