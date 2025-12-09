package com.workintech.s18d2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.workintech.s18d2.dao.VegetableRepository;


import org.springframework.stereotype.Service;
import com.workintech.s18d2.entity.Vegetable;

@Service
public class VegetableServiceImpl implements VegetableService{
      @Autowired
    private VegetableRepository vegetableRepository;

    @Override
 public List<Vegetable> getByPriceDesc() {
    return vegetableRepository.findAllByOrderByPriceDesc();
 }

    @Override
   public List<Vegetable> getByPriceAsc() {
    return vegetableRepository.findAllByOrderByPriceAsc();
   }

   @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.findByNameContaining(name);
    } 

}