package com.example.dbhw.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DesignDTO {
    private int targetProduct;
    private int slaveProduct;
    private int lossRate;
    private int count;
}
