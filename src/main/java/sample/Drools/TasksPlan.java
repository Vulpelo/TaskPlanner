package sample.Drools;

import org.drools.planner.api.domain.entity.PlanningEntity;
import org.drools.planner.api.domain.solution.PlanningEntityCollectionProperty;
import org.drools.planner.core.score.buildin.hardandsoft.HardAndSoftScore;
import org.drools.planner.core.score.buildin.hardandsoftlong.HardAndSoftLongScore;
import org.drools.planner.core.solution.Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@PlanningEntity
public class TasksPlan implements Solution<HardAndSoftScore> {
    private int id;

    private List<Task> taskList;
    private List<Worker> workerList;

    private HardAndSoftScore score;

    public List<Worker> getWorkerList() {
        return workerList;
    }

    @PlanningEntityCollectionProperty
    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }


    @Override
    public HardAndSoftScore getScore() {
        return score;
    }

    public void setScore(HardAndSoftScore score) {
        this.score = score;
    }

    @Override
    public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(workerList);
        // Do not add the planning entity's (processList) because that will be done automatically
        return facts;
    }

    @Override
    public TasksPlan cloneSolution() {
        TasksPlan clone = new TasksPlan();
        clone.id = id;

        clone.workerList = workerList;

        List<Task> clonedProcessList = new ArrayList<Task>(taskList.size());
        for (Task process : taskList) {
            Task clonedTask = process.clone();
            clonedProcessList.add(clonedTask);
        }
        clone.taskList = clonedProcessList;

        clone.score = score;
        return clone;
    }
}
