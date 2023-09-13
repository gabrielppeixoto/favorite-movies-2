package com.gabrielpeixoto.favoritemovies2.repository;

import com.gabrielpeixoto.favoritemovies2.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    public Movie findByMovieId(Long id);
}
