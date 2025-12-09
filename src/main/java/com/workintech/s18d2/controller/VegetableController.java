package com.workintech.s18d2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class VegetableController {

@Autowired
private VegetableRepository vegetableRepository;

@GetMapping("/vegetables")
public List<Vegetable> findAllByOrderByPriceAsc() {    
    return findAllByOrderByPriceAsc();
}

@GetMapping("/vegetables/{id}")
public Vegetable findById(@PathVariable long id) {
        return vegetableRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vegetable not found"));
}

@GetMapping("/vegetables/desc")
public List<Vegetable> findAllByOrderByPriceDesc() {
    return vegetableRepository.findAllByOrderByPriceDesc();
}

@PostMapping("/vegetables")
public Vegetable addOrUpdate(@RequestBody Vegetable vegetable) {
    return vegetableRepository.save(vegetable);
}

@PostMapping("/vegetables/{name}")
public List<Vegetable> findByName(@PathVariable String name) {
    return vegetableRepository.findByNameContaining(name);
}

@DeleteMapping("/vegetables/{id}")
public Vegetable deleteById(@PathVariable long id) {
    Optional<Vegetable> deletedVegetable = vegetableRepository.findById(id);
    vegetableRepository.deleteById(id);
    return deletedVegetable.orElse(null);
}

}
