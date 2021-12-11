package com.example.dbhw.model;

import com.example.dbhw.model.DTO.DesignDTO;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Design implements MyEntity<DesignDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "targetProduct", nullable = false)
    @Setter(AccessLevel.NONE)
    private Product targetProduct;

    @ManyToOne
    @JoinColumn(name = "slaveProduct", nullable = false)
    @Setter(AccessLevel.NONE)
    private Product slaveProduct;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int lossRate; // PERCENTAGE BY INT

    @Column(nullable = false)
    @ColumnDefault("1")
    private int count;

    @ManyToOne
    @JoinColumn(name = "createUser", nullable = false)

    private User createUser;

    protected void setTargetProduct(int t){
        targetProduct = Product.builder()
                .id(t)
                .build();
    }
    protected void setSlaveProduct(int s){
        slaveProduct = Product.builder()
                .id(s)
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
    public void DTOtoEntity(DesignDTO designDTO) {
        targetProduct = Product.builder()
                .id(designDTO.getTargetProduct())
                .build();
        slaveProduct = Product.builder()
                .id(designDTO.getSlaveProduct())
                .build();
        lossRate = designDTO.getLossRate();
        count = designDTO.getCount();
    }
}
