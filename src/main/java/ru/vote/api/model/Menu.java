package ru.vote.api.model;

import java.time.LocalDateTime;

public class Menu extends AbstractBaseEntity {

    private LocalDateTime date;

    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(Integer id, LocalDateTime date, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
