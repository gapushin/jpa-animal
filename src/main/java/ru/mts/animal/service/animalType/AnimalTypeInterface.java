package ru.mts.animal.service.animalType;

import ru.mts.animal.entity.AnimalType;

import java.util.List;
import java.util.Optional;

public interface AnimalTypeInterface {
     List<AnimalType> getAllAnimalTypes();
     Optional<AnimalType> getAnimalType(Long id);
}
