package com.example.springbootmvcdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    List<Products> productList = new ArrayList<>();
    private AtomicLong nextID = new AtomicLong(0);

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
        productList.add(new Products(nextID.incrementAndGet(), "Product1", 32423.345));
        productList.add(new Products(nextID.incrementAndGet(),"Product2", 3463.476));
    }

    public Products getProduct(Long ID)
    {
        Products result = null;
        for(Products prod : productList)
        {
            if(prod.getID() == ID)
            {
                result = prod;
            }
        }
        return result;
    }

    public Products addProduct(Products product)
    {
        product.setID(nextID.incrementAndGet());
        productList.add(product);
        return product;
    }
}
