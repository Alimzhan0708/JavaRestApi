package Anipanic.API.mappers;

import Anipanic.API.models.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.Id =  resultSet.getString("Id");
        movie.EnglishName = resultSet.getString("EnglishName");
        movie.RussianName = resultSet.getString("RussianName");
        movie.Description = resultSet.getString("Description");
        movie.MoviePicture = resultSet.getString("MoviePicture");

        return movie;
    }
}
