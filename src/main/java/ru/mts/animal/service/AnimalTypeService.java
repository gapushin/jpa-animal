package ru.mts.animal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mts.animal.entity.AnimalType;
import ru.mts.animal.repository.AnimalTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalTypeService {
    @Autowired
    AnimalTypeRepository animalTypeRepository;

    public List<AnimalType> getAllAnimalTypes() {
        return animalTypeRepository.findAll();
    }

    public Optional<AnimalType> getAnimalType(Long id) {
        return animalTypeRepository.findById(id);
    }
}
