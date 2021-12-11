package com.example.dbhw.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private int id;
    private String company;
    private String name;
    private String standard;
    private String unit;
    private int price;
    private String createUser;
}
