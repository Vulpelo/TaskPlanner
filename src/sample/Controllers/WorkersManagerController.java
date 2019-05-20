package sample.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Model.PlanData;
import sample.Plan.Avaliability;
import sample.Plan.Worker;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class WorkersManagerController {
    public void addNewButton() {
        System.out.println("ADDED workers");
        List<Worker> workerList = new ArrayList<>();

        for (int i=0; i<3; i++) {
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
        PlanData.setWorkers(workerList);

    }
}
