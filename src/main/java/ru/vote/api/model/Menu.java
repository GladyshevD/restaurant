package ru.vote.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"date_time", "restaurant_id"},
        name = "menu_unique_date_restaurant_idx")})
public class Menu extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false)
    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Restaurant restaurant;

    public Menu() {
    }

    public Menu(Integer id, Restaurant restaurant) {
        super(id);
        this.date = new Date();
        this.restaurant = restaurant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
