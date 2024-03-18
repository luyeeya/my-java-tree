package prototype;

public class Phone {
    private String name;
    private String released;
    private String capacity;

    private CPU cpu;

    public Phone() {
    }

    public Phone(Phone target) {
        if (target != null) {
            this.name = target.name;
            this.released = target.released;
            this.capacity = target.capacity;
            this.cpu = target.cpu.clone();
        }
    }

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

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    @Override
    public Phone clone() {
        return new Phone(this);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", released='" + released + '\'' +
                ", capacity='" + capacity + '\'' +
                ", cpu=" + cpu +
                '}';
    }
}
