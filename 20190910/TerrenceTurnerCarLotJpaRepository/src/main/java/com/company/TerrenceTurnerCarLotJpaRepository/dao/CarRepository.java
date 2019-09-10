package com.company.TerrenceTurnerCarLotJpaRepository.dao;

import com.company.TerrenceTurnerCarLotJpaRepository.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByMake(String make);

    List<Car> findByColor(String color);

    List<Car> findByMakeAndColor(String make, String color);
}
