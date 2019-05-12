package sample.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Model.TaskList;
import sample.Plan.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainController {

    private TaskList taskList_ToWindow = new TaskList();

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

    public void reloadPlanButton() {
        Plan plan = new Plan(LocalDateTime.of(2019, 1, 1, 8, 0));


        List<Task> taskList = new ArrayList<>();
        Task task = new Task(LocalDateTime.of(2019, 1,3,15,0), 19);
        taskList.add(task);


        List<Worker> workerList = new ArrayList<>();

        for (int i=0; i<4; i++) {
            Worker worker = new Worker();

            worker.setName("Worker" + (i + 1));

            Avaliability avaliability = new Avaliability();
            avaliability.addAvaliabilityTime(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(15, 0));
            avaliability.addAvaliabilityTime(DayOfWeek.TUESDAY, LocalTime.of(8, 0), LocalTime.of(15, 0));
            avaliability.addAvaliabilityTime(DayOfWeek.WEDNESDAY, LocalTime.of(8, 0), LocalTime.of(15, 0));
            avaliability.addAvaliabilityTime(DayOfWeek.FRIDAY, LocalTime.of(8, 0), LocalTime.of(15, 0));

            worker.setAvaliability(avaliability);

            workerList.add(worker);
        }

        plan.createPlan(taskList, workerList);

        Map<Long, WorkTime> workersWorkingTime = plan.getWorkersWorkingTime();


        taskList_ToWindow.createNewTaskList("Task 1", plan.toString());
    }



}
