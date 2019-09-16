package ru.vote.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vote.api.model.Dish;
import ru.vote.api.repository.DishRepository;
import ru.vote.api.repository.RestaurantRepository;

import static ru.vote.api.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Dish create(Dish dish, int restaurantId) {
        log.info("create {}", dish);
        Assert.notNull(dish, "dish must not be null");
        dish.setRestaurant(restaurantRepository.get(restaurantId));
        return dishRepository.save(dish);
    }

    public void delete(int id) {
        checkNotFoundWithId(dishRepository.delete(id), id);
    }

    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(dishRepository.update(dish), dish.getId());
    }
}
