package com.gabrielpeixoto.favoritemovies2.controller;

import com.gabrielpeixoto.favoritemovies2.entity.Movie;
import com.gabrielpeixoto.favoritemovies2.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieRepository repository;

    @PostMapping
    public ResponseEntity<Object> createMovie(@RequestBody Movie movie)
    {
        repository.save(movie);
        Map<String, String> data = new HashMap<>();
        data.put("name", movie.getName());
        data.put("description", movie.getDescription());
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> findAllMovies()
    {
        List<Movie> movies = repository.findAll();
        Map<String, List<Movie>> data = new HashMap<>();
        data.put("values", movies);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findMovieById(@PathVariable("id") Long id)
    {
        Map<String, String> data = new HashMap<>();
        HttpStatus code;
        try {
            Movie mv = repository.findByMovieId(id);
            data.put("name", mv.getName());
            data.put("description", mv.getDescription());
            code = HttpStatus.OK;
        } catch (Exception e) {
            data.put("error", e.getMessage());
            code = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(data, code);
    }
}
