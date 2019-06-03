package sample.Drools;

import org.drools.planner.core.score.Score;
import org.drools.planner.core.score.buildin.hardandsoft.DefaultHardAndSoftScore;
import org.drools.planner.core.score.director.simple.SimpleScoreCalculator;

public class TaskPlanScoreCalculator implements SimpleScoreCalculator<TasksPlan> {

    @Override
    public Score calculateScore(TasksPlan tasksPlan) {
        return DefaultHardAndSoftScore.valueOf(0,15);
    }
}
