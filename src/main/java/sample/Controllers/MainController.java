package sample.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Drools.TaskPlanConf;
import sample.Model.PlanData;
import sample.Model.TaskList;
import sample.Plan.*;

import java.time.LocalDateTime;
import java.util.Map;

public class MainController {

    private TaskList taskList_ToWindow = new TaskList();

    public void workersManagerButton() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/workersManager.fxml"));

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
            Parent root = FXMLLoader.load(getClass().getResource("/tasksManager.fxml"));

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

    public void reloadPlanButton() {
        taskList_ToWindow.clear();

        Plan plan = new Plan(LocalDateTime.of(2019, 1, 1, 0, 0));
/// TODO: JBoss Drools Planner
        // TODO: zaleznosci miedzy taskami
        // kompetencje pracownika
        //
        TaskPlanConf taskPlanConf = new TaskPlanConf();
        taskPlanConf.solve();

        plan.createPlan(PlanData.getTaskList(), PlanData.getWorkers());

        for (Map.Entry<Long, String> mapEntry: plan.toMapString().entrySet()) {
            taskList_ToWindow.createNewTaskList("Task " + mapEntry.getKey(), mapEntry.getValue().toString());
        }
    }

}
