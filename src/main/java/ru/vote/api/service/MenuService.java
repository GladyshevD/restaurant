package ru.vote.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vote.api.model.Menu;
import ru.vote.api.repository.MenuRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository repository;

    @Autowired
    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<Menu> getByDate(LocalDateTime dateTime) {
        return null;
    }

    public Menu save(Menu menu) {
        return null;
    }

    public boolean delete(Menu menu) {
        return false;
    }
}