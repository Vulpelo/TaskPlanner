package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.TaskList;

public class Main extends Application {

    Stage primaryStage;

    private void afterStart(Scene scene) {
        TaskList.setScene(scene);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Task Planner");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();

        afterStart(scene);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
