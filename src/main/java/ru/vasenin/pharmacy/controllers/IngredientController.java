package ru.vasenin.pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.vasenin.pharmacy.domain.Ingredient;
import ru.vasenin.pharmacy.domain.SimpleResult;
import ru.vasenin.pharmacy.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/")
public class IngredientController {

    private final IngredientService ingredientService ;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    /*Получение списка всех ингредиентов*/
    @GetMapping
    @ResponseBody
    public SimpleResult<List<Ingredient>> getAll(){
        return new SimpleResult<>(ingredientService.getAll());
    }

    /*Получение ингредиентов постранично*/
    @GetMapping("/pages/{num}")
    @ResponseBody
    public SimpleResult<Page<Ingredient>> getByPages(@PathVariable("num") String num) {
        return new SimpleResult<>(ingredientService.getPage(Integer.parseInt(num)));
    }
}
