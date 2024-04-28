package object2stack;

import java.time.Instant;

public class Order {
    private String id;

    private Instant time;

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", time=" + time +
                '}';
    }
}


