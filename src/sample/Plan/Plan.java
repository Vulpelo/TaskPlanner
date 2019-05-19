package sample.Plan;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Plan {
    private LocalDateTime planStart;

    // restrains while finding solution
    private Integer maxWorkersAtTheTime = 2;
    private Integer hTimeStamp = 1;

    // found workers and their's hours
    private Map<Long, WorkTime> workersWorkingTime = new HashMap<>();

    private WorkersWorkingTimeForTasks workersWorkingTimeForTasks = new WorkersWorkingTimeForTasks();

    private List<Worker> workers;


    public Plan() {
        planStart = LocalDateTime.now();
    }

    public Plan(LocalDateTime planStart) {
        this.planStart = planStart;
    }


    public Map<Long, WorkTime> getWorkersWorkingTime() {
        return workersWorkingTime;
    }

    public void createPlan(List<Task> tasks, List<Worker> workers) {
        this.workers = workers;

        System.out.println(tasks.size() + " tasks; " + workers.size() + " workers;");
        System.out.println("Creating PLAN...");

        for (Task task: tasks) {
            workersWorkingTimeForTasks.createTask(task.getTask_id());
            planForTask(task);
        }
    }

    private void planForTask(Task task) {
        LocalDateTime currentCheckTime = LocalDateTime.from(planStart);
        LocalDateTime currentEndCheckTime = currentCheckTime.plusHours(hTimeStamp);

        Integer currentWorkTime = 0;

        while (currentWorkTime < task.getRequredHourTime()) {

            currentWorkTime += getWorkersInPeriod(currentCheckTime, currentEndCheckTime, task.getRequredHourTime() - currentWorkTime);

            currentCheckTime = currentCheckTime.plusHours(hTimeStamp);
            currentEndCheckTime = currentEndCheckTime.plusHours(hTimeStamp);
        }


    }

    private Integer getWorkersInPeriod(LocalDateTime currentCheckTime, LocalDateTime currentEndCheckTime, Integer leftHours) {
        Integer thisPeriodWorkerAmount = 0;

        for (Worker worker: workers) {

            if (worker.isAvaliable(currentCheckTime, currentEndCheckTime)) {

                if ( workersWorkingTime.containsKey(worker.getWorker_id()) ) {
                    workersWorkingTime.get(worker.getWorker_id()).addDateTime(currentCheckTime, currentEndCheckTime);
                }
                else {
                    WorkTime workTime = new WorkTime();
                    workTime.addDateTime(currentCheckTime, currentEndCheckTime);

                    workersWorkingTime.put(worker.getWorker_id(), workTime);
                }

                thisPeriodWorkerAmount++;
                if (thisPeriodWorkerAmount >= maxWorkersAtTheTime || thisPeriodWorkerAmount >=  leftHours) {
                    return thisPeriodWorkerAmount;
                }
            }

        }

        return thisPeriodWorkerAmount;
    }

    @Override
    public String toString() {
        String out = "";

        Set<Long> keySet  = workersWorkingTime.keySet();

        for (Long key: keySet) {
            out += "Worker " + key + "\n";

            out += workersWorkingTime.get(key).toString();
        }

        return out;
    }
}
