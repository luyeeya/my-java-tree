package delegate;

public class Boss {
    public static void main(String[] args) {
        Leader leader = new Leader();
        Designer designer = new Designer();
        leader.lead(designer);
        Programmer programmer = new Programmer();
        leader.lead(programmer);

        leader.doTask(Task.PROGRAMMING);
        leader.doTask(Task.DESIGN_UI);
        leader.doTask(Task.MAKE_PPT);
    }
}
