package users;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @FXML
    private BorderPane mainPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/user.fxml"));

        mainPane = loader.load();
        Scene scene = new Scene(mainPane);
        stage.setTitle("User List");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}