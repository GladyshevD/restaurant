package ru.vote.api.model;

import java.time.LocalDateTime;

public class Vote extends AbstractBaseEntity {
    private LocalDateTime date;

    private User user;

    private Menu menu;

    public Vote() {
    }

    public Vote(Integer id, LocalDateTime date, User user, Menu menu) {
        super(id);
        this.date = date;
        this.user = user;
        this.menu = menu;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
