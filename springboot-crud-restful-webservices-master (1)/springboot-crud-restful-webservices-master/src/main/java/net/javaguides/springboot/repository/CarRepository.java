package net.javaguides.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.entity.AddCar;

public interface CarRepository extends CrudRepository<AddCar, Integer> {

}
