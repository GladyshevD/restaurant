package ru.vote.api.repository;

import org.springframework.stereotype.Repository;
import ru.vote.api.model.User;

import java.util.List;

@Repository
public class UserRepository {
    public User add(User user) {
        return null;
    }

    public boolean delete(int id) {
        return false;
    }

    public User get(int id) {
        return null;
    }

    public User getByEmail(String email) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }
}
