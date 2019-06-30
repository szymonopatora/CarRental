package com.carrental.persistence.repository;

import com.carrental.persistence.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
