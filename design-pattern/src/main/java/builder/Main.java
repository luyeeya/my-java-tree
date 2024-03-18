package builder;

public class Main {
    public static void main(String[] args) {
        Phone miPhone = new PhoneBuilder()
                .name("MI 6")
                .released("2017年4月28日")
                .capacity("64GB")
                .build();
        System.out.println(miPhone);

        Phone iphone = new PhoneBuilder()
                .name("Iphone XS")
                .released("2018年9月13日")
                .capacity("256GB")
                .build();
        System.out.println(iphone);
    }
}
