package com.workintech.s18d2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;

   public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

 @Override
public List<Fruit> getByPriceDesc() {
    return fruitRepository.getByPriceDesc();
 }

    @Override
   public List<Fruit> getByPriceAsc() {
    return fruitRepository.getByPriceAsc();
   }

   @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }


    @Override
    public Fruit getById(long id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new com.workintech.s18d2.exceptions.PlantException("Fruit not found with id: " + id));
    }
   
    @Override
    public Optional<Fruit> findById(long id) {
        return fruitRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        fruitRepository.deleteById(id);
    }

   @Override
public Fruit delete(long id) {
    Fruit fruit = fruitRepository.findById(id)
        .orElseThrow(() -> new PlantException("Fruit not found with id: " + id));
    fruitRepository.delete(fruit);
    return fruit;
}
        @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
}

