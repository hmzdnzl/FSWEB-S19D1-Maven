package com.workintech.s18d2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
public class FruitController {
@Autowired
private FruitService fruitService;


@GetMapping("/fruit")
public List<Fruit> findAllByOrderByPriceAsc() {    
    return fruitService.getByPriceAsc();
}

@GetMapping("/fruit/{id}")
public Fruit getById(@PathVariable long id) {
    return fruitService.getById(id);
}

@GetMapping("/fruit/desc")
public List<Fruit> findAllByOrderByPriceDesc() {
    return fruitService.getByPriceDesc();
}

    @PostMapping("/fruit")
public Fruit save(@RequestBody Fruit fruit) {
    return fruitService.save(fruit);
}

@GetMapping("/fruit/name/{name}")
public List<Fruit> searchByName(@PathVariable String name) {
    return fruitService.searchByName(name);
}

@DeleteMapping("/fruit/{id}")
public Fruit delete(@PathVariable long id) {
    return fruitService.delete(id);
}



}
