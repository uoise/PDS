package com.example.dbhw.mapper;

import com.example.dbhw.model.DTO.ProductDTO;
import com.example.dbhw.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends MyMapper<Product> {
    void create(Product product);

    void update(Product product);

    void delete(int productId);

    Product getById(int id);

    ProductDTO getDTOById(int id);

    List<Product> getAll();

    List<Product> getByName(String name);

    List<Product> getByCompany(String name);
}
