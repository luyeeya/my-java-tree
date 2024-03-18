package delegate;

import java.util.ArrayList;
import java.util.List;

public class Leader implements Employee {
    private final List<Employee> employeeList = new ArrayList<>();

    public void lead(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void doTask(Task task) {
        switch (task) {
            case PROGRAMMING:
                employeeList.stream()
                        .filter(e -> e instanceof Programmer)
                        .findFirst()
                        .ifPresent(e -> e.doTask(task));
                break;
            case DESIGN_UI:
                employeeList.stream()
                        .filter(e -> e instanceof Designer)
                        .findFirst()
                        .ifPresent(e -> e.doTask(task));
                break;
            case MAKE_PPT:
                System.out.println("主管：" + task);
                break;
            default:
                System.out.println("向Boss求助");
        }
    }
}
