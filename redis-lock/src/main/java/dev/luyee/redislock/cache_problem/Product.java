package dev.luyee.redislock.cache_problem;

public class Product {
    private final String id;

    public Product(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
