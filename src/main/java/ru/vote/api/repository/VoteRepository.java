package ru.vote.api.repository;

import org.springframework.stereotype.Repository;
import ru.vote.api.model.User;
import ru.vote.api.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepository {

    public Vote add(Vote vote, User user) {
        return null;
    }

    public boolean delete(Vote vote, User user) {
        return false;
    }

    public List<Vote> getForUser(User user, LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }

    public List<Vote> getForAdmin(LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }
}