package ru.vote.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "restaurants", uniqueConstraints =
        {@UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx")})
public class Restaurant extends AbstractNamedEntity {

    @Column(name = "added", nullable = false, columnDefinition = "timestamp default now()")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @NotNull
    private Date added = new Date();

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }
}
