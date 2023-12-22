package com.example.springbootmvcdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    List<Products> productList = new ArrayList<>();

    @Autowired
    private ValueDemo valueDemo;

    public List<Products> getProducts()
    {
        System.out.println(valueDemo.getProductURL());
        return productList;
    }

    // To inject into the lifecycle of this bean Products
    // When you add a breakpoint to this method and when it hits here, the application will not be ready to accept the request at this point.
    // It is only ready when all the beans are created.
    // This is a annotation based project ( earlier we did xml based bean injection )
    // Here init method is initialized using POSTCONTRUCT annotation
    @PostConstruct
    public void initMethod()
    {
        // This is the part of lifeCycle of this bean
        productList.add(new Products("Product1", 32423.345));
        productList.add(new Products("Product2", 3463.476));
    }
}
