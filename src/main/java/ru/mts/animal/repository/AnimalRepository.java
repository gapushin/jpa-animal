package ru.mts.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.mts.animal.entity.Animal;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query("FROM Animal where name = ?1")
    List<Animal> getAnimalsByName(String name);
}
