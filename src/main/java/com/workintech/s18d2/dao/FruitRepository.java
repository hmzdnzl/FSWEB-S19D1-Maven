package com.workintech.s18d2.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workintech.s18d2.entity.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
 @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
List<Fruit> getByPriceDesc();
   @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
List<Fruit> getByPriceAsc();
    @Query("SELECT f FROM Fruit f WHERE f.name LIKE %:name%")
    List<Fruit> searchByName(String name);
  
  
}