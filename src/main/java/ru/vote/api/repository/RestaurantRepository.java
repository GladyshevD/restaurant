package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.vote.api.model.Restaurant;

import java.util.List;

@Repository
public class RestaurantRepository {

    private final RestaurantCrudRepository crudRepository;

    @Autowired
    public RestaurantRepository(RestaurantCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Restaurant> getAll() {
        return crudRepository.getAll();
    }

    public Restaurant save(Restaurant restaurant) {
        if (!restaurant.isNew() && crudRepository.findById(restaurant.getId()).orElse(null) == null) {
            return null;
        }
        return crudRepository.save(restaurant);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    public Restaurant update(Restaurant restaurant) {
        return null;
    }
}