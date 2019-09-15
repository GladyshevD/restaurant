package ru.vote.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vote.api.model.Dish;
import ru.vote.api.repository.DishRepository;

import static ru.vote.api.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final DishRepository repository;

    @Autowired
    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish create(Dish dish, int restaurantId) {
        log.info("create {}", dish);
        Assert.notNull(dish, "dish must not be null");
        dish.setRestaurant(repository.get(restaurantId));
        return repository.save(dish);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(repository.update(dish), dish.getId());
    }
}
