package ru.vote.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vote.api.model.Restaurant;
import ru.vote.api.model.Vote;
import ru.vote.api.repository.DishRepository;
import ru.vote.api.repository.RestaurantRepository;
import ru.vote.api.repository.UserRepository;
import ru.vote.api.repository.VoteRepository;
import ru.vote.api.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static ru.vote.api.util.DateTimeUtil.adjustEndDateTime;
import static ru.vote.api.util.DateTimeUtil.adjustStartDateTime;

@Service
public class VoteService {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final RestaurantRepository restaurantRepository;
    private final VoteRepository voteRepository;
    private final UserRepository userRepository;
    private final DishRepository dishRepository;

    @Autowired
    public VoteService(RestaurantRepository restaurantRepository, VoteRepository voteRepository,
                       UserRepository userRepository, DishRepository dishRepository) {
        this.restaurantRepository = restaurantRepository;
        this.voteRepository = voteRepository;
        this.userRepository = userRepository;
        this.dishRepository = dishRepository;
    }

    public List<Restaurant> getDishesToday() {
        return getDishesBetweenDates(LocalDate.now(), LocalDate.now());
    }

    private List<Restaurant> getDishesBetweenDates(@Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        return getDishesBetweenDateTimes(adjustStartDateTime(startDate), adjustEndDateTime(endDate));
    }

    private List<Restaurant> getDishesBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return restaurantRepository.getAllByDates(startDateTime, endDateTime);
    }

    public List<Vote> getVotesBetweenDates(@Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        return getVotesBetweenDateTimes(adjustStartDateTime(startDate), adjustEndDateTime(endDate));
    }

    private List<Vote> getVotesBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Assert.notNull(startDateTime, "startDateTime must not be null");
        Assert.notNull(endDateTime, "endDateTime  must not be null");
        int userId = SecurityUtil.authUserId();
        return voteRepository.getAllByDates(startDateTime, endDateTime, userId);
    }

    public List<Vote> getVoteToday() {
        return getVotesBetweenDates(LocalDate.now(), LocalDate.now());
    }

    public Vote create(int restaurantId) {
        int userId = SecurityUtil.authUserId();
        log.info("vote for {} by user {}", restaurantId, userId);
        return checkVoteToday() && restaurantHasDishesToday(restaurantId) ?
                voteRepository.save(new Vote(null, restaurantRepository.get(restaurantId), userRepository.get(userId))) : null;
    }

    private boolean checkVoteToday() {
        return getVoteToday().isEmpty() || LocalTime.now().isBefore(LocalTime.of(11, 0, 0));
    }

    private boolean restaurantHasDishesToday(int restaurantId) {
        return dishRepository.getWithDishes(restaurantId, adjustStartDateTime(LocalDate.now()), adjustEndDateTime(LocalDate.now()));
    }
}
