package ru.mts.animal.service.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.animal.entity.Animal;
import ru.mts.animal.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalService implements AnimalInterface {
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        try {
            return animalRepository.findAll();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Animal> getAnimalsByName(String name) {
        try {
            return animalRepository.getAnimalsByName(name);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public void addAnimal(Animal animal) {
        try {
            animalRepository.save(animal);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteAnimal(Long id) {
        try {
            animalRepository.deleteById(id);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
