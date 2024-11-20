package dk.easv.mrs.GUI.Controller;

import dk.easv.mrs.BE.Movie;
import dk.easv.mrs.GUI.Model.MovieModel;
import dk.easv.mrs.GUI.util.MessageHandler;
import dk.easv.mrs.Util.MRSException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MovieViewController implements Initializable {

    @FXML
    public TextField txtMovieSearch;

    @FXML
    public ListView<Movie> lstMovies;

    @FXML
    public Button btnEdit;


    private MovieModel movieModel;

    // Constructor
    public MovieViewController()  {

        try {
            movieModel = new MovieModel();
        }
        catch (Exception e) {
            displayError(e);
            //e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        /*lstMovies.setItems(movieModel.getObservableMovies());

        txtMovieSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                movieModel.searchMovie(newValue);
            } catch (Exception e) {
                displayError(e);
                //e.printStackTrace();
            }
        });*/
        /*//movieModel = getModel().getMovieModel();

        btnEdit.setDisable(true);

        lstMovies.setItems(movieModel.getObservableMovies());

        txtMovieSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                movieModel.searchMovie(newValue);
            } catch (Exception e) {
                displayError(e);
                //e.printStackTrace();
            }
        });*/

        // Initialize the person table with the two columns.
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));

        // add data from observable list
        lstMovies.setItems(movieModel.getObservableMovies());
        tblMovies.setItems(movieModel.getObservableMovies());

        // table view listener (when user selects a movie in the tableview)
        tblMovies.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {
                txtTitle.setText(newValue.getTitle());
                txtYear.setText(Integer.toString(newValue.getYear()));

                btnUpdate.setDisable(false);
            }
            else {
                txtTitle.setText("");
                txtYear.setText("");

                btnUpdate.setDisable(true);
            }


        });

        // list view listener (when user selects a movie in the listview)
        lstMovies.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtTitle.setText(newValue.getTitle());
            txtYear.setText(Integer.toString(newValue.getYear()));
        });

        // Setup context search
        txtMovieSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                movieModel.searchMovie(newValue);
            } catch (MRSException e) {
                MessageHandler.displayError(e);
            }
        });

    }




    private void displayError(Throwable t)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Something went wrong");
        alert.setHeaderText(t.getMessage());
        alert.showAndWait();
    }
}
