package sample.Model;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TaskList {

    static private Scene scene;

    public TaskList() {

    }

    public TaskList(Scene nScene) {
        scene = nScene;
    }

    static public void setScene(Scene nScene) {
        scene = nScene;
    }

    public void createNewTaskList(String taskName, String description) {
        HBox box = (HBox) scene.lookup("#days");

        VBox vBox = new VBox();

        box.getChildren().add(vBox);

        Label label = new Label();
        label.setText(taskName);

        TextArea textArea = new TextArea();
        textArea.setText(description);

        vBox.getChildren().addAll(label, textArea);
    }
}
