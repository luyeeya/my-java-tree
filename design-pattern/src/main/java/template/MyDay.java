package template;

public class MyDay extends OneDay {
    @Override
    protected void haveBreakfast() {
        System.out.println("不想吃早饭~");
    }

    @Override
    protected void haveLunch() {
        System.out.println("午饭吃炒粉~");
    }

    @Override
    protected void haveDinner() {
        System.out.println("晚饭吃中餐~");
    }
}
