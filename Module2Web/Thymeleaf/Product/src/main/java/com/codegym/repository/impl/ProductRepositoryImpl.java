package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap;

    static {

        productMap = new HashMap<>();
        productMap.put(1, new Product(1, " Oppo Reno", 8900000, "Công nghệ màn hình\tAMOLED\n" +
                "Độ phân giải\tFull HD+ (1080 x 2400 Pixels)\n" +
                "Màn hình rộng\t6.4\"\n" +
                "Mặt kính cảm ứng\tKính cường lực Corning Gorilla Glass 5", "abc"));
        productMap.put(2, new Product(2, "Oppo A12", 3690000, "Công nghệ màn hình\tIPS LCD\n" +
                "Độ phân giải\tHD+ (720 x 1520 Pixels)\n" +
                "Màn hình rộng\t6.22\"\n" +
                "Mặt kính cảm ứng\tKính cường lực Corning Gorilla Glass 3", "abc"));
        productMap.put(3, new Product(3, "SamSung A71", 7900000, "Công nghệ màn hình\tSuper AMOLED\n" +
                "Độ phân giải\tFull HD+ (1080 x 2400 Pixels)\n" +
                "Màn hình rộng\t6.7\"\n" +
                "Mặt kính cảm ứng\tKính cường lực", "abc"));
        //productMap.put(1, new Product(1, "abc", 25, "xyz", "zzzz"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}
