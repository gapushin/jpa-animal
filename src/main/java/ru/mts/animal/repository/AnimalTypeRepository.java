package ru.mts.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mts.animal.entity.AnimalType;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {
}
