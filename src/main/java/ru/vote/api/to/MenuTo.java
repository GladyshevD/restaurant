package ru.vote.api.to;

import ru.vote.api.model.Dish;
import ru.vote.api.model.Restaurant;

import java.time.LocalDateTime;
import java.util.Set;

public class MenuTo {
    private final Integer id;

    private final LocalDateTime date;

    private final Restaurant restaurant;

    private final Set<Dish> dishes;

    public MenuTo(Integer id, LocalDateTime date, Restaurant restaurant, Set<Dish> dishes) {
        this.id = id;
        this.date = date;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }
}
