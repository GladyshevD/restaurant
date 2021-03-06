package ru.vote.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.api.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface RestaurantCrudRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Restaurant save(Restaurant restaurant);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT DISTINCT r FROM Restaurant r JOIN FETCH r.dishes d WHERE d.added BETWEEN :startDate AND :endDate ORDER BY r.name")
    List<Restaurant> getAllWithDishesByDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
