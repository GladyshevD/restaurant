package ru.vote.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vote.api.to.MenuTo;

import java.time.LocalDateTime;
import java.util.List;

public interface MenuToCrudRepository extends JpaRepository<MenuTo, Integer> {

    @Query("SELECT m.id, m.date, r.name, d FROM Menu m LEFT JOIN Restaurant r ON (m.restaurant.id=r.id)" +
            "LEFT JOIN Dish d ON (m.id=d.menu.id) WHERE m.date=:date")
    List<MenuTo> getAllAtDate(@Param("date") LocalDateTime ldt);


}
