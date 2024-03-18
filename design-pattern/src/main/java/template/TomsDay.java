package template;

public class TomsDay extends OneDay {
    @Override
    protected void haveBreakfast() {
        System.out.println("早饭吃燕麦~");
    }

    @Override
    protected void haveLunch() {
        System.out.println("午饭吃披萨~");
    }

    @Override
    protected void haveDinner() {
        System.out.println("晚饭吃意面~");
    }
}
