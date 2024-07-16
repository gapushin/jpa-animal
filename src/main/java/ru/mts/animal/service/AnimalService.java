package ru.mts.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.animal.entity.Animal;
import ru.mts.animal.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public List<Animal> getAnimalsByName(String name) {
        return animalRepository.getAnimalsByName(name);
    }

    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
