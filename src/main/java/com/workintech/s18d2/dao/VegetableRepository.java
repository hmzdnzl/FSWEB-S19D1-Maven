package com.workintech.s18d2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.workintech.s18d2.entity.Vegetable;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    List<Vegetable> findAllByOrderByPriceDesc();
    List<Vegetable> findAllByOrderByPriceAsc();
    List<Vegetable> findByNameContaining(String name);
}
