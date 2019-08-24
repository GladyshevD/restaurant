package ru.vote.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vote.api.repository.MenuToRepository;
import ru.vote.api.to.MenuTo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/all/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuToController {

    private final MenuToRepository repository;

    @Autowired
    public MenuToController(MenuToRepository repository) {
        this.repository = repository;
    }

    public List<MenuTo> getAllByDate(LocalDateTime localDateTime) {
        return repository.getAllAtDate(localDateTime);
    }
}
