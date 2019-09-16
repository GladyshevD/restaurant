package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.api.model.Dish;
import ru.vote.api.model.Restaurant;

import java.time.LocalDateTime;


@Repository
public class DishRepository {
    private final DishCrudRepository dishCrudRepository;

    @Autowired
    public DishRepository(DishCrudRepository dishCrudRepository) {
        this.dishCrudRepository = dishCrudRepository;
    }

    public Dish save(Dish dish) {
        return dishCrudRepository.save(dish);
    }

    @Transactional
    public Dish update(Dish dish) {
        Restaurant restaurant = dishCrudRepository.getOne(dish.getId()).getRestaurant();
        dish.setRestaurant(restaurant);
        return save(dish);
    }

    public boolean delete(int id) {
        return dishCrudRepository.delete(id) != 0;
    }

    public boolean getWithDishes(int restaurantId, LocalDateTime startDate, LocalDateTime endDate) {
        return dishCrudRepository.getForRestaurant(restaurantId, startDate, endDate) != 0;
    }
}
