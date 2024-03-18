package delegate;

public class Programmer implements Employee {
    @Override
    public void doTask(Task task) {
        System.out.println("程序员：" + task);
    }
}
