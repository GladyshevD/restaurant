package ru.vote.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.vote.api.web.View;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull(groups = View.Persist.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(groups = View.Persist.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Vote() {
    }

    public Vote(Integer id, @NotNull(groups = View.Persist.class) Restaurant restaurant, @NotNull(groups = View.Persist.class) User user) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + restaurant.toString() + user.toString() + ')';
    }
}
