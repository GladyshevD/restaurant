package ru.vote.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "menu_id"},
        name = "dishes_unique_name_menu_idx")})
public class Dish extends AbstractNamedEntity {

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Menu menu;

    public Dish() {
    }

    public Dish(Integer id, String name, Integer price, Menu menu) {
        super(id, name);
        this.price = price;
        this.menu = menu;
    }

    public Integer getPrice() {
        return price / 100;
    }

    public void setPrice(Integer price) {
        this.price = price * 100;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
