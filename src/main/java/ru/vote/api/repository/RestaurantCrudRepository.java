package ru.vote.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.vote.api.model.Restaurant;

import java.util.List;

public interface RestaurantCrudRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r")
    List<Restaurant> getAll();

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);
}
