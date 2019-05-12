package sample.Plan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkTime {
    private List<LocalDateTime[]> dateTimes = new ArrayList<>();

    void addDateTime(LocalDateTime from, LocalDateTime to) {
        int i = 0;
        if (dateTimes.isEmpty()) {
            LocalDateTime[] time = new LocalDateTime[2];
            time[0] = from;
            time[1] = to;

            dateTimes.add(time);
        }
        else {
            for (LocalDateTime[] dateTime: dateTimes) { // before then add up
                if (dateTime[1].isEqual(from)) {
                    dateTime[1] = to;
                    return;
                }
                if (dateTime[0].isAfter(to)) { //time is
                    LocalDateTime[] time = new LocalDateTime[2];
                    time[0] = from;
                    time[1] = to;

                    dateTimes.add(i, time);
                    return;
                }
                i++;
            }
            LocalDateTime[] time = new LocalDateTime[2];
            time[0] = from;
            time[1] = to;

            dateTimes.add(i, time);
        }

    }

    public List<LocalDateTime[]> getDateTimes() {
        return dateTimes;
    }

    @Override
    public String toString() {
        String out = "";

        for (LocalDateTime[] times: dateTimes) {
            out += times[0].toString() + " - " + times[1].toString() + "\n";
        }
        return out;
    }
}
