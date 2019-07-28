package ru.vote.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vote.api.model.Restaurant;
import ru.vote.api.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAllEnabled() {
        return null;
    }

    public List<Restaurant> getAll() {
        return null;
    }

    public Restaurant add(Restaurant restaurant) {
        return null;
    }

    public Restaurant deactivate(Restaurant restaurant) {
        return null;
    }
}