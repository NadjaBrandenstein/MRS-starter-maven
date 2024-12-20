package dk.easv.mrs.DAL;

// Java import
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//Project import
import dk.easv.mrs.BE.Movie;

public class MovieDAO_File implements IMovieDataAccess {

    // Relative path (den er ligeglad med hvad der ligger foran e.g c://...)
    private static final String MOVIES_FILE = "data/movie_titles.txt";
    private Path filePath = Paths.get(MOVIES_FILE);

    //The @Override annotation is not required, but is recommended for readability
    // and to force the compiler to check and generate error msg. if needed etc.
    //@Override

    /**
     * Gets all movies from the file
     * @return
     * @throws IOException
     */
    public List<Movie> getAllMovies() throws IOException {
        // Read all lines from file
        List<String> lines = Files.readAllLines(filePath);

        //Create list of movie object
        List<Movie> movies = new ArrayList<>();

        // Parse each line as movie
        // Loop through all lines in the file (List)
        for (String line: lines) {
            String[] separatedLine = line.split(",");

            // Individual movie items
            int id = Integer.parseInt(separatedLine[0]);
            int year = Integer.parseInt(separatedLine[1]);
            String title = separatedLine[2];

            if(separatedLine.length > 3)
            {
                for(int i = 3; i < separatedLine.length; i++)
                {
                    title += "," + separatedLine[i];
                }
            }
            // Create movie object
            Movie movie = new Movie(id, year, title);

            // Add movies to list
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public Movie createMovie(String title, int year) throws Exception {
        return null;
    }

    @Override
    public void updateMovie(Movie movie) throws Exception {
    }

    @Override
    public void deleteMovie(Movie movie) throws Exception {
    }
}