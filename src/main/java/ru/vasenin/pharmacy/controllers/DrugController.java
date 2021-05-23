package ru.vasenin.pharmacy.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.vasenin.pharmacy.domain.Drug;
import ru.vasenin.pharmacy.domain.SimpleDrug;
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

    @GetMapping("/all")
    @ResponseBody
    public SimpleDrug<List<Drug>> getAll() {
        return new SimpleDrug<>(drugService.getAll());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public SimpleDrug<Drug> get(@PathVariable String id) {
        return new SimpleDrug<>(drugService.getOne(Long.parseLong(id)));
    }

    @GetMapping("/pages/{num}")
    @ResponseBody
    public SimpleDrug<Page<Drug>> getByPages(@PathVariable("num") String num) {
        return new SimpleDrug<>(drugService.getPage(Integer.parseInt(num)));
    }

    @Getter
    @Setter
    public static class SaveDrugReqt {
        private String title;
        private String description;
        private int categoryId;
        private int countryId;
    }

    @PutMapping("/save")
    @ResponseBody
    public SimpleDrug<Drug> save(@RequestBody SaveDrugReqt reqt) {
        return new SimpleDrug<>(drugService.save(reqt));
    }

    @PostMapping("/update")
    @ResponseBody
    public SimpleDrug<Drug> update(@RequestBody Drug drug) {

        return new SimpleDrug<>(drugService.update(drug));
    }

    @Getter
    @Setter
    public static class SortDrug {
        private String title;
    }

    @PostMapping("/sort")
    @ResponseBody
    public SimpleDrug<List<Drug>> sort(@RequestBody SortDrug sortDrug) {
        return new SimpleDrug<>(drugService.sortByTitle(sortDrug.getTitle()));
    }


    @Getter
    @Setter
    public static class SortDrugExtended {
        private String title;
        private String description;
    }

    @PostMapping("/sort/extended")
    @ResponseBody
    public SimpleDrug<List<Drug>> sortByTitleAndDesc(@RequestBody SortDrugExtended sortDrugExtended) {
        return new SimpleDrug<>(drugService.sortByTitleAndDesc(sortDrugExtended.getTitle(),
                sortDrugExtended.getDescription()));
    }

}


