package sample.Plan;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class WorkersWorkingTimeForTasks {
    private  Map<Long, Map<Long, WorkTime>> allWorkersWorkingTime = new HashMap<>();

    boolean isWorkerBusy(Long worker_id, LocalDateTime from, LocalDateTime to) {
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

    void createTask(Long task_id) {
        allWorkersWorkingTime.put(task_id, new HashMap<>());
    }
}
