package ru.vote.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.vote.api.model.Restaurant;
import ru.vote.api.service.AdminService;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static ru.vote.api.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(value = AdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    static final String REST_URL = "rest/admin/restaurants";

    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final AdminService service;

    @Autowired
    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("get list of restaurants");
        return service.getAll();
    }

    @GetMapping(value = "/today")
    public List<Restaurant> getAllToday() {
        log.info("getAllToday");
        return service.getToday();
    }

    @GetMapping(value = "/filter")
    public List<Restaurant> getBetween(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        log.info("getAll between dates {} and {}", startDate, endDate);
        return service.getBetweenDates(startDate, endDate);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant) {
        Restaurant created = service.create(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete restaurant {}", id);
        service.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        restaurant.setId(id);
        assureIdConsistent(restaurant, id);
        log.info("update {}", restaurant);
        service.update(restaurant, id);
    }
}
