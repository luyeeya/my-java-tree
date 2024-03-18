package builder;

public class PhoneBuilder {
    private final Phone phone = new Phone();

    public PhoneBuilder name(String name) {
        phone.setName(name);
        return this;
    }

    public PhoneBuilder released(String released) {
        phone.setReleased(released);
        return this;
    }

    public PhoneBuilder capacity(String capacity) {
        phone.setCapacity(capacity);
        return this;
    }

    public Phone build() {
        return phone;
    }
}
