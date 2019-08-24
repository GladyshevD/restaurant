package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vote.api.to.MenuTo;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MenuToRepository {

    private final MenuToCrudRepository repository;

    @Autowired
    public MenuToRepository(MenuToCrudRepository repository) {
        this.repository = repository;
    }

    public List<MenuTo> getAllAtDate(LocalDateTime localDateTime) {
        return repository.getAllAtDate(localDateTime);
    }
}