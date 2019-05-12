package sample.Plan;

import java.time.LocalDateTime;

public class Task {

    private LocalDateTime deadLine;

    private Integer requredHourTime = 1;

    public Task(LocalDateTime deadLine, Integer requredHourTime) {
        this.deadLine = deadLine;
        this.requredHourTime = requredHourTime;
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
}
