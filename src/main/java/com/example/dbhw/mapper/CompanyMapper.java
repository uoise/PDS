package com.example.dbhw.mapper;

import com.example.dbhw.model.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper extends MyMapper<Company> {
    void create(Company company);

    void update(Company company);

    void delete(String name);

    Company getById(String name);

    List<Company> getAll();
}
