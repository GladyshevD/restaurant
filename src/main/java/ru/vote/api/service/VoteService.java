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

    public Vote getVoteBetweenDates(@Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        return getVoteBetweenDateTimes(adjustStartDateTime(startDate), adjustEndDateTime(endDate));
    }

    private Vote getVoteBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Assert.notNull(startDateTime, "startDateTime must not be null");
        Assert.notNull(endDateTime, "endDateTime  must not be null");
        int userId = SecurityUtil.authUserId();
        return voteRepository.getToday(startDateTime, endDateTime, userId);
    }

    public Vote getVoteToday() {
        return getVoteBetweenDates(LocalDate.now(), LocalDate.now());
    }

    public Vote vote(int restaurantId) {
        int userId = SecurityUtil.authUserId();
        Vote todayVote = getVoteToday();
        log.info("vote for {} by user {}", restaurantId, userId);
        if (restaurantHasDishesToday(restaurantId)) {
            Vote newVote = new Vote(null, restaurantRepository.get(restaurantId), userRepository.get(userId));
            if (todayVote == null) {
                return voteRepository.save(newVote);
            } else if (checkTime()) {
                newVote.setId(todayVote.getId());
                return voteRepository.save(newVote);
            } else return null;
        } else return null;
    }

    private boolean checkTime() {
        return LocalTime.now().isBefore(LocalTime.of(11, 0, 0));
    }

    private boolean restaurantHasDishesToday(int restaurantId) {
        return dishRepository.getWithDishes(restaurantId, adjustStartDateTime(LocalDate.now()), adjustEndDateTime(LocalDate.now()));
    }
}
