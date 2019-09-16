package ru.vote.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.api.model.Dish;

import java.time.LocalDateTime;

@Transactional(readOnly = true)
public interface DishCrudRepository extends JpaRepository<Dish, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Dish save(Dish item);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT COUNT (d) FROM Dish d WHERE d.restaurant.id = :restaurantId AND d.added BETWEEN :startDate AND :endDate")
    int getForRestaurant(@Param("restaurantId") int restaurantId,
                         @Param("startDate") LocalDateTime startDate,
                         @Param("endDate") LocalDateTime enDate);
}