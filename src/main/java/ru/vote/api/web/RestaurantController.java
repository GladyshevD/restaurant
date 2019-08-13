package ru.vote.api.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.vote.api.model.Restaurant;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {

    @GetMapping
    public List<Restaurant> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Restaurant find(@PathVariable int id) {
        return null;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void add(Restaurant restaurant) {
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
    }
}
