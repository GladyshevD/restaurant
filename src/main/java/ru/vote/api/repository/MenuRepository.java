package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vote.api.model.Menu;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MenuRepository {

    private final CrudMenuRepository crudMenuRepository;

    @Autowired
    public MenuRepository(CrudMenuRepository crudMenuRepository) {
        this.crudMenuRepository = crudMenuRepository;
    }

    public List<Menu> getByDate(LocalDate date) {
        return crudMenuRepository.findByDate(date);
    }

    public Menu save(Menu menu) {
        return null;
    }

    public boolean delete(Menu menu) {
        return false;
    }
}