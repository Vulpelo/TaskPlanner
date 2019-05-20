package sample.Plan;

import java.time.LocalDateTime;

public class Worker {
    private static Long id = 0L;

    private Long worker_id;
    private String name;

    private Avaliability avaliability;

    public Worker() {
        worker_id = id;
        id++;
    }

    public Worker(String name) {
        worker_id = id;
        this.name = name;
        id++;
    }

    public boolean isAvaliable(LocalDateTime localDateTime) {
        return avaliability.isAvaliable(localDateTime);
    }

    public boolean isAvaliable(LocalDateTime from, LocalDateTime to) {
        return avaliability.isAvaliable(from, to);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWorker_id(Long worker_id) {
        this.worker_id = worker_id;
    }

    public Long getWorker_id() {
        return worker_id;
    }

    public void setAvaliability(Avaliability avaliability) {
        this.avaliability = avaliability;
    }

    public Avaliability getAvaliability() {
        return avaliability;
    }

    @Override
    public String toString() {
        return getWorker_id().toString();
    }
}
