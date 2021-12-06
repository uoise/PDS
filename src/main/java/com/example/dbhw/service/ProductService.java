package com.example.dbhw.service;

import com.example.dbhw.mapper.CompanyMapper;
import com.example.dbhw.mapper.DesignMapper;
import com.example.dbhw.mapper.ProductMapper;
import com.example.dbhw.model.DTO.DesignProductDTO;
import com.example.dbhw.model.Product;
import com.example.dbhw.model.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements MyService<ProductDTO, Product> {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private DesignMapper designMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Transactional
    public void create(ProductDTO productDTO) {
        if(companyMapper.getById(productDTO.getCompany()) == null) throw new IllegalArgumentException("Product Fail: Company doesnt exist");
        Product product = new Product();
        product.DTOtoEntity(productDTO);
        productMapper.create(product);
    } // 제품 자체의 생성

    @Transactional
    public void update(int productId, ProductDTO productDTO) {
        if(companyMapper.getById(productDTO.getCompany()) == null) throw new IllegalArgumentException("Product Fail: Company doesnt exist");
        Product product = productMapper.getById(productId);
        if (product == null) throw new IllegalArgumentException("Product Update Fail: Product doesnt exist");
        product.DTOtoEntity(productDTO);
        productMapper.update(product);
    } // 제품 자체의 수정

    @Transactional
    public void delete(int productId) {
        designMapper.deleteDesignsByTargetId(productId); // 자신의 디자인 삭제
        productMapper.delete(productId); // 제품 삭제
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productMapper.getAll();
    }

    @Transactional(readOnly = true)
    public DesignProductDTO getSlaveProducts(int productId){
        Product product = productMapper.getById(productId);
        if (product == null) throw new IllegalArgumentException("Product Slaves Fail: Product doesnt exist");
        DesignProductDTO designProductDTO = new DesignProductDTO();
        designProductDTO.setSlaveProducts(designMapper.getSlaveProducts(productId));
        designProductDTO.setTargetProduct(productMapper.getDTOById(productId));
        designProductDTO.calcTotal();
        return designProductDTO;
    }

    @Transactional(readOnly = true)
    public List<Product> getListByName(String name) {
        return productMapper.getByName(name);
    }

    @Transactional(readOnly = true)
    public List<Product> getListByCompany(String name) {
        return productMapper.getByCompany(name);
    }

    @Transactional(readOnly = true)
    public Product getById(int id) {
        return productMapper.getById(id);
    }

}
