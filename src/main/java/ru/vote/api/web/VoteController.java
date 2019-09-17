package ru.vote.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vote.api.model.Restaurant;
import ru.vote.api.model.Vote;
import ru.vote.api.service.VoteService;

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
        return service.vote(restaurantId);
    }

    @GetMapping(value = "/votes/today")
    public Vote getVoteToday() {
        log.info("getVoteToday");
        return service.getVoteToday();
    }
}