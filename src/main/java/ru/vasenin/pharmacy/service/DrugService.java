package ru.vasenin.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vasenin.pharmacy.controllers.DrugController;
import ru.vasenin.pharmacy.domain.Country;
import ru.vasenin.pharmacy.domain.Drug;
import ru.vasenin.pharmacy.domain.Ingredient;
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

    /*Вывод все стран*/
    public List<Country> getAllCountry(){
        return drugRepository.allCountry();
    }

    /*Вывод всех ингредиентов*/
    public List<Ingredient> getAllIngredient(){
        return drugRepository.allIngredients();
    }

    public Drug getOne(long id) {
        return drugRepository.findById(id).orElseGet(() -> null);
    }

    public Drug save(DrugController.SaveDrugReqt reqt) {
        Drug drug = new Drug();
        drug.setTitle(reqt.getTitle());
        drug.setDescription(reqt.getDescription());

        return update(drug);
    }

    public Drug update(Drug drug) {
        return drugRepository.save(drug);
    }

    /**Сортировка препарата по названию и/или описанию без учета регистра
     * PS
     * Название метода не красиво длинное, но реализовал в таком виде для
     * практических навыков ;)
     */
    public List<Drug> sortByTitleAndDesc(String title, String description) {
        return drugRepository.findByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCase(title, description);
    }

    /*Сортировка препаратов по категории*/
    public List<Drug> sortCategory(String title){
        return drugRepository.sortCategory(title);
    }

    /*Вывод всех препаратов постранично по 5 ед. на странице*/
    public Page<Drug> getPage(int page) {
        return drugRepository.findAll(PageRequest.of(page, 5));
    }
}
