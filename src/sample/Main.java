package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    ListView<String> listView = new ListView<>();
    ObservableList<String> data = FXCollections.observableArrayList(
            "Adam", "Beka", "Lista"
    );

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();



        HBox box = (HBox) scene.lookup("#days");

        VBox vBox = new VBox();

        box.getChildren().add(vBox);

        Label label = new Label();
        label.setText("Day1321");

        vBox.getChildren().addAll(label, listView);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
