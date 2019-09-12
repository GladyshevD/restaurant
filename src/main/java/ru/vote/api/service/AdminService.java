package ru.vote.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vote.api.model.Restaurant;
import ru.vote.api.repository.RestaurantRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static ru.vote.api.util.DateTimeUtil.adjustEndDateTime;
import static ru.vote.api.util.DateTimeUtil.adjustStartDateTime;
import static ru.vote.api.util.ValidationUtil.*;

@Service
public class AdminService {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final RestaurantRepository repository;

    @Autowired
    public AdminService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    public List<Restaurant> getToday() {
        return getBetweenDates(LocalDate.now(), LocalDate.now());
    }

    public List<Restaurant> getBetweenDates(@Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        return getBetweenDateTimes(adjustStartDateTime(startDate), adjustEndDateTime(endDate));
    }

    private List<Restaurant> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Assert.notNull(startDateTime, "startDateTime must not be null");
        Assert.notNull(endDateTime, "endDateTime  must not be null");
        return repository.getAllByDates(startDateTime, endDateTime);
    }

    public Restaurant create(Restaurant restaurant) {
        checkNew(restaurant);
        log.info("create {}", restaurant);
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public void update(Restaurant restaurant, int id) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(repository.save(restaurant), id);
    }
}
