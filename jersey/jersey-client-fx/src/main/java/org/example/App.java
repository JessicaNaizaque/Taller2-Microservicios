package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(), 800, 600);
        stage.setScene(scene);
        stage.setTitle("Trips Client");
        stage.setResizable(false);
        stage.show();
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main_scene.fxml"));
        Parent parent = fxmlLoader.load();
        MainSceneController controller = fxmlLoader.getController();
        controller.initialize();
        return parent;
    }

    public static void main(String[] args) {
        launch();
    }

}