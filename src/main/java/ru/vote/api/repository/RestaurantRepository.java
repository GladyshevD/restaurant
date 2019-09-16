package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.vote.api.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RestaurantRepository {
    private static final Sort SORT_RESTAURANTS = new Sort(Sort.Direction.ASC, "name");

    private final RestaurantCrudRepository crudRepository;

    @Autowired
    public RestaurantRepository(RestaurantCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<Restaurant> getAllByDates(LocalDateTime startDate, LocalDateTime endDate) {
        return crudRepository.getAllWithDishesByDate(startDate, endDate);
    }

    public Restaurant save(Restaurant restaurant) {
        return crudRepository.save(restaurant);
    }

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    public List<Restaurant> getAll() {
        return crudRepository.findAll(SORT_RESTAURANTS);
    }

    public Restaurant get(int restaurantId) {
        return crudRepository.getOne(restaurantId);
    }
}