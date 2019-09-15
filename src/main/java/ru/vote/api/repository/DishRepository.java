package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vote.api.model.Dish;
import ru.vote.api.model.Restaurant;

import java.util.Objects;


@Repository
public class DishRepository {
    private final DishCrudRepository dishCrudRepository;
    private final RestaurantCrudRepository restaurantCrudRepository;

    @Autowired
    public DishRepository(DishCrudRepository dishCrudRepository, RestaurantCrudRepository restaurantCrudRepository) {
        this.dishCrudRepository = dishCrudRepository;
        this.restaurantCrudRepository = restaurantCrudRepository;
    }

    public Dish save(Dish dish) {
        return dishCrudRepository.save(dish);
    }

    public Dish update(Dish dish) {
        Restaurant restaurant = Objects.requireNonNull(dishCrudRepository.findById(dish.getId()).orElse(null)).getRestaurant();
        dish.setRestaurant(restaurant);
        return save(dish);
    }

    public boolean delete(int id) {
        return dishCrudRepository.delete(id) != 0;
    }

    public Restaurant get(int restaurantId) {
        return restaurantCrudRepository.getOne(restaurantId);
    }
}
