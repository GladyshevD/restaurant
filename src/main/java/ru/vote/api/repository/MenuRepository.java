package ru.vote.api.repository;

import org.springframework.stereotype.Repository;
import ru.vote.api.model.Menu;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MenuRepository {

    public List<Menu> getByDate(LocalDateTime dateTime) {
        return null;
    }

    public Menu add(Menu menu) {
        return null;
    }

    public boolean delete(Menu menu) {
        return false;
    }
}