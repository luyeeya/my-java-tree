package builder;

public class Phone {
    private String name;
    private String released;
    private String capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "MiPhone{" +
                "name='" + name + '\'' +
                ", released=" + released +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
