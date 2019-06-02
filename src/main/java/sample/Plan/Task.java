package sample.Plan;

import java.time.LocalDateTime;

public class Task {
    private static Long id = 0L;
    private Long task_id;

    private LocalDateTime deadLine;

    private Integer requredHourTime = 1;

    public Task(LocalDateTime deadLine, Integer requredHourTime) {
        this.deadLine = deadLine;
        this.requredHourTime = requredHourTime;

        task_id = id;
        id++;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setRequredHourTime(Integer requredHourTime) {
        this.requredHourTime = requredHourTime;
    }

    public Integer getRequredHourTime() {
        return requredHourTime;
    }

    @Override
    public String toString() {
        String out = task_id.toString() + " -> " + deadLine.toString() + " WH:" + requredHourTime;
        return out;
    }
}
