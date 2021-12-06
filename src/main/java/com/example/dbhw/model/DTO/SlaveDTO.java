package com.example.dbhw.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SlaveDTO {
    private int id;
    private ProductDTO productDTO;
    private int lossRate;
    private int count;
}
