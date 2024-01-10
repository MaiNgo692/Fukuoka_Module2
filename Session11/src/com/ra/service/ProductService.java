package com.ra.service;

import com.ra.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService implements IService{
    List<Product> products = new ArrayList<>();

    @Override
    public void display() {
        for(Product p: products){
            p.display();
        }
    }

    @Override
    public Optional<Product> findByModel(String findModel) {
        return products.stream().filter(p -> p.getModel().equals(findModel)).findFirst();
    }

    @Override
    public List<String> getAllModel() {
        List<String> models = new ArrayList<>();
        for(Product p: products){
            models.add(p.getModel());
        }
        return models;
    }

    @Override
    public boolean anyProductPriceMoreThousand() {
        for(Product p: products){
            if(p.getPrice() > 1000){
                return true;
            }
        }
        return false;
    }

    @Override
    public void countProductSamePrice() {
       Map<Double, List<String>> result = products.stream().collect(Collectors.groupingBy(Product::getPrice,Collectors.mapping(Product::getModel, Collectors.toList())));
    }
}
