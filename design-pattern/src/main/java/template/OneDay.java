package template;

public abstract class OneDay {
    private void wakeUp() {
        System.out.println("起床~");
    }

    protected abstract void haveBreakfast();

    protected abstract void haveLunch();

    protected abstract void haveDinner();

    private void sleep() {
        System.out.println("睡觉~");
    }

    /**
     * 算法框架
     */
    public void startOneDay() {
        wakeUp();
        haveBreakfast();
        haveLunch();
        haveDinner();
        sleep();
    }
}
