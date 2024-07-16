package ru.mts.animal.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String breed;

    private String name;

    private Double cost;

    private String character;

    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType type;

}
