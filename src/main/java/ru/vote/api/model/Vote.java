package ru.vote.api.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"date_time", "user_id"},
        name = "votes_unique_date_user_idx")})
public class Vote extends AbstractBaseEntity {

    @Column(name = "date_time", nullable = false, columnDefinition = "timestamp default now")
    @NotNull
    private Date date = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Menu menu;

    public Vote() {
    }

    public Vote(Integer id, User user, Menu menu) {
        super(id);
        this.date = new Date();
        this.user = user;
        this.menu = menu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
