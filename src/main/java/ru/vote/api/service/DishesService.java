package ru.vote.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vote.api.model.Dish;
import ru.vote.api.repository.DishesRepository;

@Service
public class DishesService {

    private final DishesRepository repository;

    @Autowired
    public DishesService(DishesRepository repository) {
        this.repository = repository;
    }

    public Dish add(Dish dish) {
        return null;
    }

    public boolean delete(Dish dish) {
        return false;
    }
}