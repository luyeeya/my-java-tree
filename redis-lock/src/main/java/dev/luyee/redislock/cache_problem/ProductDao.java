package dev.luyee.redislock.cache_problem;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    public Product query(String id) {
        System.out.println("query product by id: " + id);
        return new Product(id);
    }

    public Product update(Product product) {
        System.out.println("update product: " + JSON.toJSONString(product));
        return product;
    }

    public Product create(Product product) {
        System.out.println("create product: " + JSON.toJSONString(product));
        return product;
    }
}
