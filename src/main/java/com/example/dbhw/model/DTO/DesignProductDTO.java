package com.example.dbhw.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DesignProductDTO {
    private ProductDTO targetProduct;
    private List<SlaveDTO> slaveProducts;
    private int total;
    private int lossTotal;

    public void calcTotal() {
        total = 0;
        lossTotal = 0;
        for (SlaveDTO s : slaveProducts) {
            if (s.getProductDTO() != null) {
                total += s.getCount() * s.getProductDTO().getPrice();
                lossTotal += s.getCount() * ((float)s.getLossRate()/100) * s.getProductDTO().getPrice();
            }
        }
    }
}
