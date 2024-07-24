package ru.mts.animal.service.animal;

import java.util.List;

public interface AnimalInterface {
    List<ru.mts.animal.entity.Animal> getAllAnimals();
    List<ru.mts.animal.entity.Animal> getAnimalsByName(String name);
    void addAnimal(ru.mts.animal.entity.Animal animal);
    void deleteAnimal(Long id);
}
