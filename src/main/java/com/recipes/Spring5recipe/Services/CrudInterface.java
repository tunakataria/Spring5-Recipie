package com.recipes.Spring5recipe.Services;

public interface CrudInterface<T, ID> {

    T findById(ID id);

    T save(T object);

    Iterable<T> findAll();

    void deleteById(ID id);

    Iterable<T> findByName(String description);

}
