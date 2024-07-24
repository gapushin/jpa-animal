package ru.mts.animal.service.animalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.animal.entity.AnimalType;
import ru.mts.animal.repository.AnimalTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalTypeService implements AnimalTypeInterface {
    @Autowired
    private AnimalTypeRepository animalTypeRepository;

    @Override
    public List<AnimalType> getAllAnimalTypes() {
        try {
            return animalTypeRepository.findAll();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Optional<AnimalType> getAnimalType(Long id) {
        try {
            return animalTypeRepository.findById(id);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return Optional.empty();
        }
    }
}
