package com.recipes.Spring5recipe.repositories;

import com.recipes.Spring5recipe.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

     Optional<UnitOfMeasure> findByUnit(String unit);
}
