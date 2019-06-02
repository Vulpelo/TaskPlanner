package sample.Model;

import sample.Plan.Task;
import sample.Plan.Worker;

import java.util.ArrayList;
import java.util.List;

public class PlanData {
    static private List<Worker> workers = new ArrayList();
    static private List<Task> taskList = new ArrayList();

    public static List<Task> getTaskList() {
        return taskList;
    }

    public static List<Worker> getWorkers() {
        return workers;
    }

    public static void setTaskList(List<Task> taskList) {
        PlanData.taskList = taskList;
    }

    public static void setWorkers(List<Worker> workers) {
        PlanData.workers = workers;
    }

    public static void addTask(Task task) {
        PlanData.taskList.add(task);
    }

    public static void removeTask(Long id) {
        for (int i=0; i<taskList.size(); i++) {
            if (taskList.get(i).getTask_id().equals(id) ) {
                taskList.remove(i);
                break;
            }
        }
    }

    public static void addWorker(Worker worker) {
        PlanData.workers.add(worker);
    }

    public static void removeWorker(Long id) {
        for (int i=0; i<workers.size(); i++) {
            if (workers.get(i).getWorker_id().equals(id) ) {
                workers.remove(i);
                break;
            }
        }
    }
}
