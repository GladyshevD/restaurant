package ru.vote.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "restaurants", uniqueConstraints =
        {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends AbstractBaseEntity {

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private Set<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 100) String name) {
        super(name);
    }
}
