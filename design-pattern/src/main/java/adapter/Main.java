package adapter;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        AC220V ac220V = new AC220V();
        PowerAdapter powerAdapter = new PowerAdapter();
        phone.charge(powerAdapter.output5V(ac220V));
        phone.charge(powerAdapter.output120V(ac220V));
    }
}
