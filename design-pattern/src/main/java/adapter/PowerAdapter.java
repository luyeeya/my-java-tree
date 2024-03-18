package adapter;

public class PowerAdapter {
    public double output5V(AC220V ac220V) {
        return ac220V.outputAC() / 44;
    }

    public double output120V(AC220V ac220V) {
        return ac220V.outputAC() / 1.8333333333333333;
    }
}
