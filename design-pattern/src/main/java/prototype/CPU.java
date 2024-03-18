package prototype;

public class CPU {
    private String name;

    public CPU() {
    }

    public CPU(CPU target) {
        if (target != null) {
            this.name = target.name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public CPU clone() {
        return new CPU(this);
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                '}';
    }
}
