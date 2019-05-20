package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.Model.PlanData;
import sample.Plan.Task;

import java.time.LocalDateTime;

public class TasksManagerController {
    @FXML
    private ListView<String> tasksListView;

    @FXML
    private TextField deadLineTextField;

    @FXML
    private TextField workingHoursTextField;

    public TasksManagerController() {
    }

    public void initialize() {
        System.out.println("Initialized");
        updateListView();
    }

    public void addNewButton() {
        LocalDateTime d = LocalDateTime.parse(deadLineTextField.getText());
        Integer workHours = Integer.valueOf(workingHoursTextField.getText());

        System.out.println("ADDED tasks");
        Task task = new Task(d, workHours);

        PlanData.addTask(task);
        updateListView();
    }

    public void deleteButton() {
        String item = tasksListView.getSelectionModel().getSelectedItem();

        String[] itemSplit = item.split(" ");

        PlanData.removeTask( Long.valueOf( itemSplit[0] ) );

        updateListView();
    }

    private void updateListView() {
        ObservableList<String> items = FXCollections.observableArrayList ();
        for (Task task: PlanData.getTaskList()) {
            items.add( task.toString() );
        }
        tasksListView.setItems(items);
    }
}
