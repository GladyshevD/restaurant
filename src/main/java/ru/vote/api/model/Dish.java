package ru.vote.api.model;

public class Dish extends AbstractNamedEntity {

    private Integer price;

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
