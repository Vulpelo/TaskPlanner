package sample.Plan;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Avaliability {
    // index: 0-Mon, 1-Tuesday ... 6-Sunday
    // < List<time interval> >
    private List<List<LocalTime[]>> avaliabilityTimes;

    public Avaliability() {
        avaliabilityTimes = new ArrayList<>();

        for (int i=0; i<7; i++) {
            avaliabilityTimes.add(new ArrayList<>());
        }
    }

    public void addAvaliabilityTime(DayOfWeek dayOfWeek, LocalTime from, LocalTime to) {
        LocalTime[] times = new LocalTime[2];
        times[0] = from;
        times[1] = to;

        avaliabilityTimes.get(dayOfWeek.getValue() - 1).add( times );
    }

    public boolean isAvaliable(LocalDateTime dateTime) {
        List<LocalTime[]> times = avaliabilityTimes.get( dateTime.getDayOfWeek().getValue() - 1 );

        for (LocalTime[] time: times) {
            if ( dateTime.toLocalTime().isAfter(time[0]) && dateTime.toLocalTime().isBefore(time[1]) ) {
                return true;
            }
        }

        return false;
    }

    public boolean isAvaliable(LocalDateTime from, LocalDateTime to) {
        List<LocalTime[]> times = avaliabilityTimes.get( to.getDayOfWeek().getValue() - 1 );

        for (LocalTime[] time: times) {
            if ( from.toLocalTime().compareTo(time[0]) >= 0 && to.toLocalTime().minusSeconds(1).compareTo(time[1]) <= 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String out = "";

        for (int i=0; i<avaliabilityTimes.size(); i++) {
            for (LocalTime[] time: avaliabilityTimes.get(i)) {
                out += (i+1) + " - " + time[0].toString() + " - " + time[1].toString() + "\n";
            }
        }

        return out;
    }
}
