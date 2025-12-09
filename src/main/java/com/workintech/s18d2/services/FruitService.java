package com.workintech.s18d2.services;

import java.util.List;
import java.util.Optional;

import com.workintech.s18d2.entity.Fruit;

public interface FruitService {
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);
    Fruit save(Fruit fruit);
    Fruit delete(long id);
    Fruit getById(long id);
    Optional<Fruit> findById(long id);
    void deleteById(long id);
}
