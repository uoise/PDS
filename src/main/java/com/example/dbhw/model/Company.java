package com.example.dbhw.model;

import com.example.dbhw.model.DTO.CompanyDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Company implements MyEntity<CompanyDTO> {

    @Id
    private String name;

    @Override
    public void DTOtoEntity(CompanyDTO companyDTO) {
        name = companyDTO.getName();
    }
}
