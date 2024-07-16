package ru.mts.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.mts.animal.entity.Animal;
import ru.mts.animal.entity.AnimalType;
import ru.mts.animal.service.AnimalService;
import ru.mts.animal.service.AnimalTypeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class AnimalsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimalsApplication.class, args);
    }

    @Autowired
    AnimalService animalService;
    @Autowired
    AnimalTypeService animalTypeService;

    @Bean
    @Profile("!test")
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Running.....");

            System.out.println("— — — — — — — — — — — — — — — — — — getAllAnimals— — — — — — — — — — — — — — — — — — — — — —");
            List<Animal> animals = animalService.getAllAnimals();
            System.out.println(animals.toString());

            System.out.println("— — — — — — — — — — — — — — — — — — — —getAnimalsByName — — — — — — — — — — — — — — — — — — — —");
            List<Animal> animalsByName = animalService.getAnimalsByName("Aurora");
            System.out.println(animalsByName.toString());

            System.out.println("— — — — — — — — — — — — — — — — — — —addAnimal — — — — — — — — — — — — — — — — — — — — —");
            Optional<AnimalType> type = animalTypeService.getAnimalType(2L);

            if (type.isPresent()) {
                Animal cat = new Animal();
                cat.setBreed("Dvorovaya");
                cat.setName("Murka");
                cat.setCost(12.00);
                cat.setCharacter("Dobraya");
                cat.setBirthDate(LocalDate.of(2020, 10, 10));
                cat.setType(type.get());
                animalService.addAnimal(cat);
            } else {
                throw new RuntimeException("Animal type doesn't exist");
            }

            List<Animal> catFromDb = animalService.getAnimalsByName("Murka");
            System.out.println(catFromDb.toString());
        };
    }
}
