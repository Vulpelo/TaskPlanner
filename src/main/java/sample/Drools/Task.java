package sample.Drools;

import org.drools.planner.api.domain.entity.PlanningEntity;
import org.drools.planner.api.domain.variable.PlanningVariable;
import org.drools.planner.api.domain.variable.ValueRange;
import org.drools.planner.api.domain.variable.ValueRangeType;

import java.util.List;

@PlanningEntity(difficultyComparatorClass =  TaskDifficultyComparator.class )
public class Task {
    private int id;
    private int requiredTime;
    private int maxWorkers;

    private Worker worker;

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }
    public void setRequiredTime(int requiredTime) {
        this.requiredTime = requiredTime;
    }

    public int getId() {
        return id;
    }

    int getRequiredMultiplicand() {
        return 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }
    public int getRequiredTime() {
        return requiredTime;
    }

    @PlanningVariable
    @ValueRange(type = ValueRangeType.FROM_SOLUTION_PROPERTY, solutionProperty = "workerList")
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Task clone() {
        Task clone = new Task();
        clone.requiredTime = requiredTime;
        clone.worker = worker;
        clone.maxWorkers = maxWorkers;
        return clone;
    }
}
