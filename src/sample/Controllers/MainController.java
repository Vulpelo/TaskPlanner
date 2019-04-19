package sample.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainController {
    public void workersManagerButton() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../resources/workersManager.fxml"));

            Scene secondScene = new Scene(root, 500, 300);

            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Workers Manager");
            newWindow.setScene(secondScene);

            // Specifies the modality for new window.
            newWindow.initModality(Modality.WINDOW_MODAL);
/*
            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(primaryStage);

            // Set position of second window, related to primary window.
            newWindow.setX(primaryStage.getX() + 200);
            newWindow.setY(primaryStage.getY() + 100);
*/
            newWindow.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tasksManagerButton() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../resources/tasksManager.fxml"));

            Scene secondScene = new Scene(root, 500, 300);

            // New window (Stage)
            Stage newWindow = new Stage();
            newWindow.setTitle("Tasks Manager");
            newWindow.setScene(secondScene);

            // Specifies the modality for new window.
            newWindow.initModality(Modality.WINDOW_MODAL);
/*
            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(primaryStage);

            // Set position of second window, related to primary window.
            newWindow.setX(primaryStage.getX() + 200);
            newWindow.setY(primaryStage.getY() + 100);
*/
            newWindow.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
