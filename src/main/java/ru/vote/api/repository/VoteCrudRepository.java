package ru.vote.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.api.model.Vote;

import java.time.LocalDateTime;

@Transactional(readOnly = true)
public interface VoteCrudRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote item);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT v FROM Vote v WHERE v.user.id = :userId AND v.added BETWEEN :startDate AND :endDate")
    Vote getAllWithDishesByDate(@Param("startDate") LocalDateTime startDate,
                                @Param("endDate") LocalDateTime endDate,
                                @Param("userId") int userId);
}
