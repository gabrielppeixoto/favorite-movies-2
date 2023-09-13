package com.gabrielpeixoto.favoritemovies2.entity;

import javax.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "movies")
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(name = "movie_name", nullable = false)
    private String name;

    @Column(name = "movie_description")
    private String description;
}
