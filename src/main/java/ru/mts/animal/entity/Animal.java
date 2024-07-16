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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    protected String breed;

    protected String name;

    protected Double cost;

    protected String character;

    protected LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType type;

}
