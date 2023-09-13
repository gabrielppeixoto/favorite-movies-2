package com.gabrielpeixoto.favoritemovies2.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(name = "person_name", nullable = false)
    private String nome;
}
