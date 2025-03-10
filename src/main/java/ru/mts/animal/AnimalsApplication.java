package ru.mts.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.mts.animal.entity.Animal;
import ru.mts.animal.entity.AnimalType;
import ru.mts.animal.service.animal.AnimalService;
import ru.mts.animal.service.animalType.AnimalTypeService;

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

            System.out.println("— — — — — — — — — — — — — — — — — — —removeAnimal — — — — — — — — — — — — — — — — — — — — —");

            if (type.isPresent()) {
                Animal cat2 = new Animal();
                cat2.setBreed("Todelete");
                cat2.setName("Todelete");
                cat2.setCost(12.00);
                cat2.setCharacter("Todelete");
                cat2.setBirthDate(LocalDate.of(2020, 10, 10));
                cat2.setType(type.get());
                animalService.addAnimal(cat2);

                List<Animal> animals2 = animalService.getAllAnimals();
                System.out.println("Before remove " + animals2.toString());

                animalService.deleteAnimal(7L);

                List<Animal> animals3 = animalService.getAllAnimals();
                System.out.println("After remove " + animals3.toString());

            } else {
                throw new RuntimeException("Animal type doesn't exist");
            }
        };
    }
}
