package ru.vasenin.pharmacy.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.vasenin.pharmacy.domain.Country;
import ru.vasenin.pharmacy.domain.Drug;
import ru.vasenin.pharmacy.domain.Ingredient;
import ru.vasenin.pharmacy.domain.SimpleResult;
import ru.vasenin.pharmacy.service.DrugService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrugController {

    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    /*Получение всех препаратов*/
    @GetMapping("/all")
    @ResponseBody
    public SimpleResult<List<Drug>> getAll() {
        return new SimpleResult<>(drugService.getAll());
    }

    /*Получение всех стран производителей*/
    @GetMapping("/all/country")
    @ResponseBody
    public SimpleResult<List<Country>> getAllCountry() {
        return new SimpleResult<>(drugService.getAllCountry());
    }


    @GetMapping("/all/ingredient")
    @ResponseBody
    public SimpleResult<List<Ingredient>> getAllIngredient() {
        return new SimpleResult<>(drugService.getAllIngredient());
    }


    @GetMapping("/{id}")
    @ResponseBody
    public SimpleResult<Drug> get(@PathVariable String id) {
        return new SimpleResult<>(drugService.getOne(Long.parseLong(id)));
    }


    @GetMapping("/pages/{num}")
    @ResponseBody
    public SimpleResult<Page<Drug>> getByPages(@PathVariable("num") String num) {
        return new SimpleResult<>(drugService.getPage(Integer.parseInt(num)));
    }

    @Getter
    @Setter
    public static class SaveDrugReqt {
        private String title;
        private String description;
    }

    @PostMapping("/save")
    @ResponseBody
    public SimpleResult<Drug> save(@RequestBody SaveDrugReqt reqt) {
        return new SimpleResult<>(drugService.save(reqt));
    }

    @PutMapping("/update")
    @ResponseBody
    public SimpleResult<Drug> update(@RequestBody Drug drug) {
        return new SimpleResult<>(drugService.update(drug));
    }

    @Getter
    @Setter
    public static class SortDrugExtended {
        private String title;
        private String description;
    }

    @PostMapping("/sort/extended")
    @ResponseBody
    public SimpleResult<List<Drug>> sortByTitleAndDesc(@RequestBody SortDrugExtended sortDrugExtended) {
        return new SimpleResult<>(drugService.sortByTitleAndDesc(sortDrugExtended.getTitle(),
                sortDrugExtended.getDescription()));
    }

    @PostMapping("/sort/category")
    @ResponseBody
    public SimpleResult<List<Drug>> sortByCategory(@RequestBody SortDrugExtended sortDrugExtended){
        return new SimpleResult<>(drugService.sortCategory(sortDrugExtended.getTitle()));
    }

}


