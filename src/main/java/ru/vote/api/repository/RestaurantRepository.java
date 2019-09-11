package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vote.api.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RestaurantRepository {

    private final RestaurantCrudRepository crudRepository;

    @Autowired
    public RestaurantRepository(RestaurantCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Restaurant> getAll() {
        return crudRepository.getAll(LocalDateTime.now());
    }

    public Restaurant save(Restaurant restaurant) {
        if (!restaurant.isNew() && crudRepository.findById(restaurant.getId()).orElse(null) == null) {
            return null;
        }
        return crudRepository.save(restaurant);
    }

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }
}