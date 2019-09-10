package com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dao;

import com.company.TerrenceTurnerCoffeeInventoryJpaRepository.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster, Integer> {
}
