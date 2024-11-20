package dk.easv.mrs.GUI.Model;
import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.BLL.MovieManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;

public class MovieModel {

    private ObservableList<Movie> moviesToBeViewed;

    private MovieManager movieManager;

    public MovieModel() throws Exception {
        movieManager = new MovieManager();
        moviesToBeViewed = FXCollections.observableArrayList();
        moviesToBeViewed.addAll(movieManager.getAllMovies());
    }


    public ObservableList<Movie> getObservableMovies() {

        return moviesToBeViewed;
    }

    public void searchMovie(String query) throws Exception {
        List<Movie> searchResults = movieManager.searchMovies(query);
        moviesToBeViewed.clear();
        moviesToBeViewed.addAll(searchResults);
    }

    /*public void createNewMovie(Movie newMovie) throws MRSException {
        Movie m = movieManager.createNewMovie(newMovie);
        moviesToBeViewed.add(m); // update list

        // loading entire file again... not optimal
        //moviesToBeViewed.clear();
        //moviesToBeViewed.addAll(movieManager.getAllMovies());
    }


    public void updateMovie(Movie updatedMovie) throws MRSException {
        // update movie in DAL layer (through the layers)
        movieManager.updateMovie(updatedMovie);

        // update observable list (and UI)
        Movie m = moviesToBeViewed.get(moviesToBeViewed.indexOf(updatedMovie));
        m.setTitle(updatedMovie.getTitle());
        m.setYear(updatedMovie.getYear());
    }


    public void deleteMovie(Movie selectedMovie) throws MRSException {
        // delete movie in DAL layer (through the layers)
        movieManager.deleteMovie(selectedMovie);

        // remove from observable list (and UI)
        moviesToBeViewed.remove(selectedMovie);
    }*/
}

