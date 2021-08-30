package Anipanic.API.controllers;

import Anipanic.API.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

    private static final String URL = "jdbc:postgresql://localhost:5432/Anipanic";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";

    private static Connection connection;

    static {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping
    public ArrayList<Movie> GetMovies() throws SQLException {
        ArrayList<Movie> movies = new ArrayList<>();
        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM \"Movies\"";
        ResultSet resultSet = statement.executeQuery(SQL);

        while(resultSet.next())
        {
            Movie movie = new Movie();
            movie.Id =  resultSet.getString("Id");
            movie.EnglishName = resultSet.getString("EnglishName");
            movie.RussianName = resultSet.getString("RussianName");
            movie.Description = resultSet.getString("Description");
            movie.MoviePicture = resultSet.getString("MoviePicture");

            movies.add(movie);
        }

        return movies;
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
