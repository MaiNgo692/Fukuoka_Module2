package com.ra.service;

import com.ra.model.Product;

import java.util.List;
import java.util.Optional;

public interface IService {
    void display();
    Optional<Product> findByModel(String model);
    List<String> getAllModel();
    boolean anyProductPriceMoreThousand();
    void countProductSamePrice();

}
