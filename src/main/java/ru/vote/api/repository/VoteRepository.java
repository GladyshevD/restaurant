package ru.vote.api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.api.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class VoteRepository {
    private final VoteCrudRepository repository;

    @Autowired
    public VoteRepository(VoteCrudRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Vote save(Vote vote) {
        return repository.save(vote);
    }

    public List<Vote> getAllByDates(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return repository.getAllWithDishesByDate(startDate, endDate, userId);
    }
}
