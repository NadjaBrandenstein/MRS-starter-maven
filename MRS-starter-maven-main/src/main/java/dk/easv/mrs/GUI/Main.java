package dk.easv.mrs.GUI;
import dk.easv.mrs.GUI.util.MessageHandler;
import dk.easv.mrs.Util.MRSException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
       try {
           Parent root = FXMLLoader.load(getClass().getResource("/views/MovieView.fxml"));

           primaryStage.setTitle("MRS");
           primaryStage.setScene(new Scene(root, 600, 475));
           primaryStage.show();
       }
       catch (Exception e) {
           MessageHandler.displayError(new MRSException("Error starting application", e));
       }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
