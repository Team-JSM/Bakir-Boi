import JDBC.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       FXMLLoader loader=new FXMLLoader(new File("UI/MainMenu.fxml").toURI().toURL());
        Parent root=loader.load();


       // Parent root = FXMLLoader.load(getClass().getResource("/UI/MainMenu.fxml"));

/*
        Parent root =FXMLLoader.load(getClass().getResource("UI/MainMenu.fxml"));
*/
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bakir Khata");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
