package ru.vote.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.vote.api.model.Restaurant;
import ru.vote.api.model.Vote;
import ru.vote.api.service.VoteService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    static final String REST_URL = "rest/user";
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final VoteService service;

    @Autowired
    public VoteController(VoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Restaurant> getDishesToday() {
        log.info("getDishesToday");
        return service.getDishesToday();
    }

    @GetMapping(value = "/vote/{restaurantId}")
    public Vote vote(@PathVariable int restaurantId) {
        return service.create(restaurantId);
    }

    @GetMapping(value = "/filter")
    public List<Vote> getBetween(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        log.info("getAll between dates {} and {}", startDate, endDate);
        return service.getVotesBetweenDates(startDate, endDate);
    }

    @GetMapping(value = "/votes/today")
    public List<Vote> getVoteToday() {
        log.info("getAllToday");
        return service.getVoteToday();
    }
}