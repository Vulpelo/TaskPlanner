package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import sample.Model.PlanData;
import sample.Plan.Avaliability;
import sample.Plan.Worker;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WorkersManagerController {

    @FXML
    private ListView<String> workersListView;

    @FXML
    private TextArea workerTextArea;

    public void initialize() {
        updateListView();
    }

    public void addNewButton() {
        String text = workerTextArea.getText();

        String[] timesDays = text.split("\n");

        Worker worker = new Worker();
        worker.setName("Worker" + worker.getWorker_id());

        Avaliability avaliability = new Avaliability();

        for (String timeDay: timesDays) {
            String[] time = timeDay.split(" - ");

            int dayNumber = Integer.valueOf(time[0]);
            if (dayNumber < 1)
                dayNumber = 1;
            else if (dayNumber > 7)
                dayNumber = 7;

            DayOfWeek day = DayOfWeek.of( dayNumber );
            LocalTime start = LocalTime.parse(time[1]);
            LocalTime end = LocalTime.parse(time[2]);
            avaliability.addAvaliabilityTime(day, start, end);
        }
        worker.setAvaliability(avaliability);

        PlanData.addWorker(worker);

        updateListView();
    }

    public void deleteButton() {
        String item = workersListView.getSelectionModel().getSelectedItem();

        String[] itemSplit = item.split(" ");

        PlanData.removeWorker( Long.valueOf( itemSplit[0] ) );

        updateListView();
    }

    private void updateListView() {
        ObservableList<String> items = FXCollections.observableArrayList ();
        for (Worker worker: PlanData.getWorkers()) {
            items.add( worker.toString() );
        }
        workersListView.setItems(items);
    }
}
