package ru.vote.api.model;

public class Restaurant extends AbstractNamedEntity {

    private boolean enabled = true;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }
}
