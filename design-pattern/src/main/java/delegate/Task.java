package delegate;

public enum Task {
    PROGRAMMING("编程"),
    DESIGN_UI("UI设计"),
    MAKE_PPT("汇报");

    private final String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
