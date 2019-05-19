package sample.Plan;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WorkersWorkingTimeForTasks {
    private  Map<Long, Map<Long, WorkTime>> allWorkersWorkingTime = new HashMap<>();

    public boolean isWorkerBusy(Long worker_id, LocalDateTime from, LocalDateTime to) {
        for (Map<Long, WorkTime> map: allWorkersWorkingTime.values()) {

            // if worker exists
            if (map.containsKey(worker_id)) {
                if (map.get(worker_id).isWorkingBetween(from, to)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createTask(Long task_id) {
        allWorkersWorkingTime.put(task_id, new HashMap<>());
    }

    public void addWorkingTime(Long task_id, Long worker_id, LocalDateTime from, LocalDateTime to) {
        if (allWorkersWorkingTime.containsKey(task_id)) {
            Map<Long, WorkTime> workersWorkingTime = allWorkersWorkingTime.get(task_id);

            if ( workersWorkingTime.containsKey(worker_id) ) {
                workersWorkingTime.get(worker_id).addDateTime(from, to);
            }
            else {
                WorkTime workTime = new WorkTime();
                workTime.addDateTime(from, to);

                workersWorkingTime.put(worker_id, workTime);
            }

        }
    }

    public Map<Long, String> toMapString() {
        Map<Long, String> map = new HashMap<>();
        String out;

        for (Map.Entry<Long, Map<Long, WorkTime>> taskEntry: allWorkersWorkingTime.entrySet()) {
            out = "";

            for (Map.Entry<Long, WorkTime> workEntry: taskEntry.getValue().entrySet()) {
                out += "Worker " + workEntry.getKey() + "\n"
                        + workEntry.getValue().toString();
            }
            map.put(taskEntry.getKey(), out);
        }

        return map;
    }

    @Override
    public String toString() {
        String out = "";

        for (Map.Entry<Long, Map<Long, WorkTime>> taskEntry: allWorkersWorkingTime.entrySet()) {
            out += "Task " + taskEntry.getKey() + "\n";

            for (Map.Entry<Long, WorkTime> workEntry: taskEntry.getValue().entrySet()) {
                out += "Worker " + workEntry.getKey() + "\n";

                out += workEntry.getValue().toString();
            }

        }

        return out;
    }
}
