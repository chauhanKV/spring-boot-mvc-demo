package com.example.springbootmvcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// RestController is indirectly including @Component annotation inside its definition, which means it will create spring bean upon initialization.
// @Component is used manually in Spring projects to ask the application to create bean.
@RestController
public class ProductsController {

    //@Autowired - is used for dependency injection.
    //It first created bean of ProductService first and created bean of ProductController then injected ProductService class in this controller.
    //This is field DI using JAVA reflection
    @Autowired
    private ProductService productService;

    // Above is same as
    // This is constructor based DI
    //    public ProductsController(ProductService productService) {
    //        this.productService = productService;
    //    }

    @GetMapping("/Products")
    public List<Products> getProducts()
    {
        return productService.getProducts();
    }
}
