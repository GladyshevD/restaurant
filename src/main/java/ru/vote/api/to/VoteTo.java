package ru.vote.api.to;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class VoteTo implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Date added = new Date();

    @NotNull
    private Integer userId;

    @NotNull
    private Integer restaurantId;

    public VoteTo(@NotNull Integer userId, @NotNull Integer restaurantId) {
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
