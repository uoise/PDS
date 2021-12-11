package com.example.dbhw.model;

import com.example.dbhw.model.DTO.ProductDTO;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product implements MyEntity<ProductDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "company", nullable = false)
    @Setter(AccessLevel.PROTECTED)
    private Company company;

    @Column(nullable = false)
    private String name;

    @Column
    private String standard;

    @Column
    private String unit;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "createUser", nullable = false)
    @Setter(AccessLevel.NONE)
    private User createUser;

    protected void setCompany(String s) {
        company = Company.builder()
                .name(s)
                .build();
    }

    public void setCreateUser(Object o) {
        if (o instanceof String) {
            createUser = User.builder()
                    .username((String) o)
                    .build();
        } else if (o instanceof User) {
            createUser = (User) o;
        } else {
            throw new IllegalArgumentException("User Mapping Fail");
        }
    }

    @Override
    public void DTOtoEntity(ProductDTO productDTO) {
        if (productDTO.getCompany() == null || productDTO.getCompany().length() < 0)
            throw new IllegalArgumentException("ProductDTO Convert Fail : name is empty");
        if (productDTO.getPrice() < 0)
            throw new IllegalArgumentException("ProductDTO Convert Fail : price must be over 0");
        name = productDTO.getName();
        standard = productDTO.getStandard();
        unit = productDTO.getUnit();
        company = Company.builder()
                .name(productDTO.getCompany()).build();
        price = productDTO.getPrice();
    }

}
