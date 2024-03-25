package dev.luyee;

public class Monkey {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                '}';
    }
}
