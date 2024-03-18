package delegate;

public class Designer implements Employee {
    @Override
    public void doTask(Task task) {
        System.out.println("设计师: " + task);
    }
}
