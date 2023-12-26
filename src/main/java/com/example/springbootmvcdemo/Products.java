package com.example.springbootmvcdemo;

import lombok.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private Long ID;
    private String name;
    private Double cost;
}
