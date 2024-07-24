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

    @Column
    private String breed;

    @Column
    private String name;

    @Column
    private Double cost;

    @Column
    private String character;

    @Column
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    @Column
    private AnimalType type;

}
