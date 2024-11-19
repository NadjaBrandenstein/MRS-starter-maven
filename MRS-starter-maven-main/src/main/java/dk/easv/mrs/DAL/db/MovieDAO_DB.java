/*package dk.easv.mrs.DAL.db;

import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.DAL.IMovieDataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO_DB implements IMovieDataAccess {

    @Override
    public List<Movie> getAllMovies() throws Exception {

       DBConnector databaseConnector = new DBConnector();

        ArrayList<Movie> allMovies = new ArrayList<>();

        // try-with-resources
        try (Connection conn = databaseConnector.getConnection();
             Statement stmt = conn.createStatement())
        {
            String sql = "SELECT * FROM dbo.Movie;";
            ResultSet rs = stmt.executeQuery(sql);

            // Loop through rows from the database result set
            while (rs.next()) {

                //Map DB row to Movie object
                int id = rs.getInt("Id");
                String title = rs.getString("Title");
                int year = rs.getInt("year");

                Movie movie = new Movie(id, year, title);
                allMovies.add(movie);
            }
            return allMovies;

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new Exception("Could not get movies from database", ex);
        }

    }

    @Override
    public Movie createMovie(Movie newMovie) throws Exception {
        String sql = "INSERT INTO dbo.Movie () VALUES (?,?);";

        DBConnector databaseConnector = new DBConnector();


        try (Connection conn = databaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Bind parameters
            stmt.setString(1,newMovie.getTitle());
            stmt.setInt(2, newMovie.getYear());

            // Run the specified SQL statement
            stmt.executeUpdate();

            // Get the generated ID from the DB
            ResultSet rs = stmt.getGeneratedKeys();
            int id = 0;

            if (rs.next()) {
                id = rs.getInt(1);
            }

            // Create movie object and send up the layers
            Movie createdMovie = new Movie(id, newMovie.getYear(), newMovie.getTitle());

            return createdMovie;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new Exception("Could not create movie", ex);
        }
    }

    @Override
    public void updateMovie(Movie movie) throws Exception {

    }

    @Override
    public void deleteMovie(Movie movie) throws Exception {

    }
}*/
