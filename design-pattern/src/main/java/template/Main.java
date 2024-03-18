package template;

public class Main {
    public static void main(String[] args) {
        MyDay myDay = new MyDay();
        myDay.startOneDay();

        System.out.println("-----------------------------");

        TomsDay tomsDay = new TomsDay();
        tomsDay.startOneDay();
    }
}
