package com.example.springbootmvcdemo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class ValueDemo {
    @Value("${product.site}")
    private String productURL;

    public String getValue()
    {
        return productURL;
    }
}
