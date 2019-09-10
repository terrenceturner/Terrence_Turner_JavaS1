package com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dao;

import com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

    List<Coffee> findCoffeeByRoaster(String roaster);

    List<Coffee> findCoffeeByType(String type);

    List<Coffee> findByRoasterAndType(String roaster, String type);
}
