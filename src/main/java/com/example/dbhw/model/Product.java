package com.example.dbhw.model;

import com.example.dbhw.model.DTO.ProductDTO;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Product implements MyEntity<ProductDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "company")
    @Setter(AccessLevel.PROTECTED)
    private Company company;

    @Column(nullable = false)
    private String name;

    @Column
    private String standard;

    @Column
    private String unit;

    @Column
    private int price;

    protected void setCompany(String s){
        company = Company.builder()
                .name(s)
                .build();
    }

    @Override
    public void DTOtoEntity(ProductDTO productDTO) {
        if (productDTO.getCompany() == null || productDTO.getCompany().length() < 0) throw new IllegalArgumentException("ProductDTO Convert Fail : name is empty");
        if (productDTO.getPrice() < 0) throw new IllegalArgumentException("ProductDTO Convert Fail : price must be over 0");
        name = productDTO.getName();
        standard = productDTO.getStandard();
        unit = productDTO.getUnit();
        company = Company.builder()
                .name(productDTO.getCompany()).build();
        price = productDTO.getPrice();
    }

}
