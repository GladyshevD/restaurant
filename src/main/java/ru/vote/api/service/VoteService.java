package ru.vote.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vote.api.model.User;
import ru.vote.api.model.Vote;
import ru.vote.api.repository.VoteRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

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