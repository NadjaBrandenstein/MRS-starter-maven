package dk.easv.mrs.BLL;

import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.BLL.util.MovieSearcher;
import dk.easv.mrs.DAL.IMovieDataAccess;
import dk.easv.mrs.DAL.MovieDAO_File;
import dk.easv.mrs.DAL.MovieDAO_Mock;

import java.io.IOException;
import java.util.List;

public class MovieManager {

    private MovieSearcher movieSearcher = new MovieSearcher();
    private IMovieDataAccess movieDAO;

    public MovieManager() throws IOException {
        //movieDAO = new MovieDAO_Mock();
        movieDAO = new MovieDAO_File();

    }

    public List<Movie> getAllMovies() throws Exception {
        try {
            return movieDAO.getAllMovies();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> searchMovies(String query) throws Exception {
        List<Movie> allMovies = getAllMovies();
        List<Movie> searchResult = movieSearcher.search(allMovies, query);
        return searchResult;
    }
}
