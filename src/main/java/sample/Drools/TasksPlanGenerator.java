package sample.Drools;

import java.util.ArrayList;
import java.util.List;

public class TasksPlanGenerator {
    public TasksPlan generateTasksPlan() {
        TasksPlan tasksPlan = new TasksPlan();
        //
        List<Task> tasks = new ArrayList<>();
        for (int i=0; i<3; i++) {
            Task task = new Task();
            task.setMaxWorkers(5);
            task.setRequiredTime(20);
            tasks.add(task);
        }
        tasksPlan.setTaskList(tasks);
        //
        List<Worker> workers = new ArrayList<>();
        for (int i=0; i<5; i++) {
            Worker worker = new Worker();
            worker.setWorkTime(18);
            workers.add(worker);
        }
        tasksPlan.setWorkerList(workers);
        //
        return tasksPlan;
    }

}
