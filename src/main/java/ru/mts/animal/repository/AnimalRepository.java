package ru.mts.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mts.animal.entity.Animal;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> getAnimalsByName(String name);
}
