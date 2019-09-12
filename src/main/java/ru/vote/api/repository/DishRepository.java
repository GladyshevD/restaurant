package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vote.api.model.Dish;


@Repository
public class DishRepository {
    private final DishCrudRepository dishCrudRepository;

    private final RestaurantCrudRepository restaurantCrudRepository;

    @Autowired
    public DishRepository(DishCrudRepository dishCrudRepository, RestaurantCrudRepository restaurantCrudRepository) {
        this.dishCrudRepository = dishCrudRepository;
        this.restaurantCrudRepository = restaurantCrudRepository;
    }

    public Dish save(Dish dish, int id) {
        if (!dish.isNew() && restaurantCrudRepository.findById(id).orElse(null) == null) {
            return null;
        }
        dish.setRestaurant(restaurantCrudRepository.getOne(id));
        return dishCrudRepository.save(dish);
    }

    public boolean delete(int id) {
        return dishCrudRepository.delete(id) != 0;
    }
}
