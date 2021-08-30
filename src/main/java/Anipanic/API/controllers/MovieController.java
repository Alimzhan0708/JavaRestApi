package Anipanic.API.controllers;

import Anipanic.API.mappers.MovieMapper;
import Anipanic.API.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Movie> GetMovies() throws SQLException {
       return jdbcTemplate.query("SELECT * FROM \"Movies\"", new MovieMapper());
    }

    @GetMapping("{movieId}")
    public String GetMovie(String movieId)
    {
        return "movie";
    }

    @PostMapping()
    public String CreateMovie()
    {
        return "movie created";
    }
}
