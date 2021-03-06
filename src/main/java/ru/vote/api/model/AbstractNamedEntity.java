package ru.vote.api.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity {

    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    public AbstractNamedEntity() {
    }

    public AbstractNamedEntity(@NotBlank @Size(min = 2, max = 100) String name) {
        this.name = name;
    }

    public AbstractNamedEntity(Integer id, @NotBlank @Size(min = 2, max = 100) String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
}
