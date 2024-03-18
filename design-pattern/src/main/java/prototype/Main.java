package prototype;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setName("Iphone XS");
        phone.setReleased("2018年9月13日");
        phone.setCapacity("256GB");
        CPU cpu = new CPU();
        cpu.setName("A12 仿生");
        phone.setCpu(cpu);
        System.out.println(phone);

        Phone phoneClone = phone.clone();
        System.out.println(phoneClone);

        System.out.println(phone == phoneClone);
        System.out.println(phone.getCpu() == phoneClone.getCpu());
    }
}
